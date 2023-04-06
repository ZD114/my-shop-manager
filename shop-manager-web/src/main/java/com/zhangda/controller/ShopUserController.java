package com.zhangda.controller;

import com.zhangda.common.PageResult;
import com.zhangda.service.ShopUserService;
import com.zhangda.service.common.CommonService;
import com.zhangda.pojo.ShopUser;
import com.zhangda.pojo.params.ShopUserParams;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import java.util.HashMap;

/**
 * @author zhangda
 * @date: 2023/3/31
 **/
@RestController
@RequestMapping("/user")
public class ShopUserController {

    @DubboReference
    public ShopUserService shopUserService;
    @DubboReference
    public CommonService commonService;

    private static final Logger log = LoggerFactory.getLogger(ShopUserController.class);

    @PostMapping("/list")
    public Flux<PageResult<ShopUser>> list(@RequestBody ShopUserParams searchParam) {
        var pageResult = new PageResult<ShopUser>();
        var params = new HashMap<String, Object>();
        var sql = new StringBuilder("SELECT * FROM shop_user WHERE 1=1 ");

        if (StringUtils.isNotBlank(searchParam.getUsername())) {
            sql.append(" AND username like :username ");
            params.put("username", "%" + searchParam.getUsername() + "%");

        }

        if (StringUtils.isNotBlank(searchParam.getNickname())) {
            sql.append(" AND nickname like :nickname ");
            params.put("nickname", "%" + searchParam.getNickname() + "%");

        }

        var sqlCount = new StringBuilder("SELECT COUNT(1) FROM( " + sql + " GROUP BY id ) eq");

        var totalCount = commonService.countLine(sqlCount.toString(), params);

        log.info("总数量：{}", totalCount);

        if (totalCount > 0) {

            var start = searchParam.getPageIndex() == 0 ? 0
                    : (searchParam.getPageIndex() - 1) * searchParam.getPageSize();

            sql.append(" GROUP BY id ORDER BY id DESC LIMIT :start,:pageSize ");
            params.put("start", start);
            params.put("pageSize", searchParam.getPageSize());

            var resources = shopUserService.searchPageList(sql.toString(), params);

            pageResult.setData(resources);
        }

        pageResult.setTotal(totalCount);
        pageResult.setTotalPages((long) Math.ceil(totalCount / (double) searchParam.getPageSize()));

        return Flux.just(pageResult);
    }
}
