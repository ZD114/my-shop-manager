package com.zhangda.service.impl;

import com.zhangda.common.Constant;
import com.zhangda.common.Result;
import com.zhangda.service.ShopUserService;
import com.zhangda.pojo.ShopUser;
import com.zhangda.service.utils.JdbcUtility;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author zhangda
 * @date: 2023/3/31
 **/
@Service
@DubboService
public class ShopUserServiceImpl implements ShopUserService {

    @Autowired
    private NamedParameterJdbcTemplate nameJdbcTemplate;

    @Override
    public List<ShopUser> searchPageList(String sql, Map<String, Object> params) {
        return nameJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(ShopUser.class));
    }

    @Override
    public Result addUser(ShopUser shopUser) {
        var keyHolder = new GeneratedKeyHolder();
        var now = LocalDateTime.now();

        shopUser.setUpdateTime(now);
        shopUser.setCreateTime(now);

        nameJdbcTemplate.update(JdbcUtility.getInsertSql(shopUser, true, Constant.ID),
                JdbcUtility.getSqlParameterSource(shopUser, Constant.ID), keyHolder);

        shopUser.setId(keyHolder.getKey().longValue());

        return Result.ok().data(Constant.RESULT, shopUser);
    }
}
