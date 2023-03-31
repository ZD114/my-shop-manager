package com.zhangda.service.impl;

import com.zhangda.interfaces.ShopUserService;
import com.zhangda.pojo.ShopUser;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zhangda
 * @date: 2023/3/31
 **/
@Service
@DubboService
public class ShopUserServiceImpl implements ShopUserService {

    @Resource
    private NamedParameterJdbcTemplate nameJdbcTemplate;

    @Override
    public List<ShopUser> searchPageList(String sql, Map<String, Object> params) {
        return nameJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(ShopUser.class));
    }
}
