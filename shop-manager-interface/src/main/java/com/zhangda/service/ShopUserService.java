package com.zhangda.service;

import com.zhangda.pojo.ShopUser;

import java.util.List;
import java.util.Map;

/**
 * @author zhangda
 * @date: 2023/3/31
 **/
public interface ShopUserService {
    List<ShopUser> searchPageList(String sql, Map<String, Object> params);
}
