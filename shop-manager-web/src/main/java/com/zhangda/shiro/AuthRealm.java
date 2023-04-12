package com.zhangda.shiro;

import com.zhangda.common.Constant;
import com.zhangda.pojo.ShopContent;
import com.zhangda.pojo.ShopUser;
import com.zhangda.service.ShopRoleService;
import com.zhangda.service.ShopUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangda
 * @date: 2023/4/10
 **/
public class AuthRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(AuthRealm.class);

    private ShopUserService userService;

    private ShopRoleService roleResService;

    public AuthRealm(ShopUserService userService, ShopRoleService roleResService) {
        super();
        this.userService = userService;
        this.roleResService = roleResService;
    }

    public ShopRoleService getRoleResService() {
        return roleResService;
    }

    public void setRoleResService(ShopRoleService roleResService) {
        this.roleResService = roleResService;
    }

    public ShopUserService getUserService() {
        return userService;
    }

    public void setUserService(ShopUserService userService) {
        this.userService = userService;
    }

    // 授权 当前端页面出现Shiro标签时，就会执行授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        log.info("授权");

        var user = (ShopUser) pc.fromRealm(this.getName()).iterator().next();// 根据realm的名字去找对应的realm

        var permissions = new ArrayList<String>();

        // 得到该用户所有资源权限
        var result = roleResService.getResByUserId(user.getId());

        if (result.getCode() == 200) {
            var modules = (List<ShopContent>) result.getData().get(Constant.RESULT);

            for (ShopContent res : modules) {

                permissions.add(res.getContentName());
            }
        }

        var info = new SimpleAuthorizationInfo();

        info.addStringPermissions(permissions);// 添加用户的模块（权限）

        return info;
    }

    // 认证 token 代表用户在界面输入的用户名和密码
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("认证");

        // 1.向下转型
        var upToken = (UsernamePasswordToken) token;

        // 2.调用业务方法，实现根据用户名查询
        var result = userService.findUserByName(upToken.getUsername());

        // 如果查询成功
        if (result.getCode() == 200) {
            var list = (List<ShopUser>) result.getData().get(Constant.RESULT);

            if (list.size() == 0) {
                throw new UnknownAccountException(); // 用户名错误
            }

            var user = list.get(0);

            if (user == null) {
                throw new UnknownAccountException(); // 如果用户名错误
            }

            var info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());

            // 去除密码,将user对象序列化
            user.setPassword(null);

            var session = SecurityUtils.getSubject().getSession();
            session.setAttribute(Constant.CURRENT_USER_INFO, user);

            return info; // 此处如果返回，就会立即进入到密码比较器
        }

        return null;// 就会出现异常
    }
}
