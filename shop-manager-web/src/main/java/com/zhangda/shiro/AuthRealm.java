package com.zhangda.shiro;

import com.zhangda.service.ShopRoleService;
import com.zhangda.service.ShopUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author zhangda
 * @date: 2023/4/10
 **/
public class AuthRealm extends AuthorizingRealm {
    private ShopUserService userService;

    private ShopRoleService roleResService;

    public AuthRealm(ShopUserService userService, ShopRoleService roleResService) {
        super();
        this.userService = userService;
        this.roleResService = roleResService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
