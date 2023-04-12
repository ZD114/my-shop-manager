package com.zhangda.controller;

import com.zhangda.common.Result;
import com.zhangda.service.ShopRoleService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色控制类
 *
 * @author zhangda
 * @date: 2023/4/10
 **/
@RestController
public class ShopRoleController {

    @DubboReference
    private ShopRoleService shopRoleService;

    @GetMapping("/{id}")
    public Result getResByUserId(@PathVariable Long id) {
        return shopRoleService.getResByUserId(id);
    }
}
