package com.zhangda.service.impl.common;

import com.zhangda.service.common.CommonService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zhangda
 * @date: 2023/3/31
 **/
@Service
@DubboService
public class CommonServiceImpl implements CommonService {

    @Autowired
    private NamedParameterJdbcTemplate nameJdbcTemplate;

    @Override
    public Integer countLine(String sql, Map<String, Object> params) {
        return nameJdbcTemplate.queryForObject(sql, params, Integer.class);
    }
}
