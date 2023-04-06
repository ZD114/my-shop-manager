package com.zhangda.service.impl;

import com.zhangda.common.Constant;
import com.zhangda.common.Result;
import com.zhangda.pojo.ShopUserInfo;
import com.zhangda.pojo.model.ShopUserInfoRepository;
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
import java.util.HashMap;
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
    public Result addUser(ShopUserInfoRepository shopUser) {
        var keyHolder = new GeneratedKeyHolder();
        var keyHolder2 = new GeneratedKeyHolder();
        var now = LocalDateTime.now();
        var user = new ShopUser();
        var userInfo = new ShopUserInfo();

        BeanUtils.copyProperties(shopUser, user);
        BeanUtils.copyProperties(shopUser, userInfo);

        user.setUpdateTime(now);
        user.setCreateTime(now);
        userInfo.setUpdateTime(now);
        userInfo.setCreateTime(now);

        nameJdbcTemplate.update(JdbcUtility.getInsertSql(user, true, Constant.ID),
                JdbcUtility.getSqlParameterSource(user, Constant.ID), keyHolder);

        userInfo.setUserId(keyHolder.getKey().longValue());

        nameJdbcTemplate.update(JdbcUtility.getInsertSql(userInfo, true, Constant.ID),
                JdbcUtility.getSqlParameterSource(userInfo, Constant.ID), keyHolder2);

        shopUser.setUserId(keyHolder.getKey().longValue());
        shopUser.setId(keyHolder2.getKey().longValue());

        return Result.ok().data(Constant.RESULT, shopUser);
    }

    @Override
    public Result delUser(Long id) {
        var param = new HashMap<String, Object>();

        param.put("id", id);

        nameJdbcTemplate.update("delete from shop_user where id = :id", param);
        nameJdbcTemplate.update("delete from shop_user_info where user_id = :id", param);

        return Result.ok();
    }

    @Override
    public Result queryUserInfo(Long id) {
        var param = new HashMap<String, Object>();

        param.put("id", id);

        var sql = new StringBuilder("select a.username,a.password,a.nickname,a.is_admin,a.is_approve,a.is_freeze,b.* ");
        sql.append("from shop_user a left join shop_user_info b on a.id = b.user_id ");
        sql.append("where a.id = :id ");

        var formData = nameJdbcTemplate.query(sql.toString(), param, new BeanPropertyRowMapper<>(ShopUserInfoRepository.class));

        if (formData.size() == 0) {
            return Result.ok().data(null);
        }

        return Result.ok().data(Constant.RESULT, formData.get(0));
    }

    @Override
    public Result updateUser(ShopUserInfoRepository repository) {
        return null;
    }
}
