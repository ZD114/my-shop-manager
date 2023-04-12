package com.zhangda.service.impl;

import com.zhangda.common.Constant;
import com.zhangda.common.Result;
import com.zhangda.pojo.ShopContent;
import com.zhangda.service.ShopRoleService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author zhangda
 * @date: 2023/4/10
 **/
@Service
@DubboService
public class ShopRoleServiceImpl implements ShopRoleService {

    @Autowired
    private NamedParameterJdbcTemplate nameJdbcTemplate;

    @Override
    public Result getResByUserId(Long id) {
        var sql = new StringBuilder();
        sql.append("select d.content_name from shop_user a,shop_role b,shop_user_role c,shop_content d,shop_role_content e ");
        sql.append("where a.id = c.user_id and b.id = c.role_id and b.id = e.role_id and d.id = e.content_id ");
        sql.append("and a.id = :id and a.is_delete = 0 and b.is_delete = 0 order by d.id");

        var param = new HashMap<String,Long>();

        param.put("id", id);

        var list = nameJdbcTemplate.query(sql.toString(), param, new BeanPropertyRowMapper<>(ShopContent.class));

        return Result.ok().data(Constant.RESULT, list);
    }
}
