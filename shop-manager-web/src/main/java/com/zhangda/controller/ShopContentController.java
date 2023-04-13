package com.zhangda.controller;

import com.zhangda.common.Result;
import com.zhangda.pojo.ShopContent;
import com.zhangda.service.ShopContentService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单目录模块控制类
 *
 * @author zhangda
 * @date: 2023/4/13
 **/
@RestController
@RequestMapping("/content")
public class ShopContentController {

    @DubboReference
    private ShopContentService shopContentService;

    /**
     * 增加
     *
     * @param shopContent
     * @return
     */
    @PostMapping("")
    public Result addShopContent(@RequestBody ShopContent shopContent) {
        return shopContentService.addShopContent(shopContent);
    }
}
