package com.zhangda.controller;

import com.zhangda.common.Result;
import com.zhangda.common.ResultCodeEnum;
import com.zhangda.pojo.ShopUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author zhangda
 * @date: 2023/4/10
 **/
@RestController
@RequestMapping("/login")
public class UserLoginController {

    @PostMapping("")
    public Result login(@RequestBody ShopUser user, HttpSession session) {

        var validate = (String) session.getAttribute("validateCode");

        if (validate == null) {
            return Result.error(ResultCodeEnum.DATA_SEARCH_ERROR);
        }

        if (!validate.equals(user.getMsn())) {
            return Result.error(ResultCodeEnum.MSN_ERROR);
        }

        // 1.得到Subject
        var subject = SecurityUtils.getSubject();

        // 2.调用登录方法
        var token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        session.setMaxInactiveInterval(60 * 60);

        subject.login(token);// 当这一代码执行时，就会自动跳入到AuthRealm中认证方法

        return Result.ok();
    }
}
