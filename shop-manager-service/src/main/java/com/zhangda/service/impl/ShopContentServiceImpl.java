package com.zhangda.service.impl;

import com.zhangda.common.Constant;
import com.zhangda.common.Result;
import com.zhangda.pojo.ShopContent;
import com.zhangda.service.ShopContentService;
import com.zhangda.service.utils.JdbcUtility;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author zhangda
 * @date: 2023/4/13
 **/
@Service
@DubboService
public class ShopContentServiceImpl implements ShopContentService {

    @Autowired
    private NamedParameterJdbcTemplate nameJdbcTemplate;

    @Override
    public Result addShopContent(ShopContent shopContent) {
        var keyHolder = new GeneratedKeyHolder();
        var now = LocalDateTime.now();

        shopContent.setCreateTime(now);
        shopContent.setUpdateTime(now);

        nameJdbcTemplate.update(JdbcUtility.getInsertSql(shopContent, true, Constant.ID),
                JdbcUtility.getSqlParameterSource(shopContent, Constant.ID), keyHolder);

        shopContent.setId(keyHolder.getKey().longValue());

        return Result.ok().data(Constant.RESULT, shopContent);
    }
}
