package com.zhangda.service;

import com.zhangda.common.Result;
import com.zhangda.pojo.ShopUser;
import com.zhangda.pojo.model.ShopUserInfoRepository;

import java.util.List;
import java.util.Map;

/**
 * @author zhangda
 * @date: 2023/3/31
 **/
public interface ShopUserService {
    List<ShopUser> searchPageList(String sql, Map<String, Object> params);

    Result addUser(ShopUserInfoRepository shopUser);

    Result delUser(Long id);

    Result queryUserInfo(Long id);

    Result updateUser(ShopUserInfoRepository repository);
}
