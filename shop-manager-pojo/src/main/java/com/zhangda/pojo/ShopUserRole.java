package com.zhangda.pojo;

import java.io.Serializable;

/**
 * 用户角色中间表
 *
 * @author zhangda
 * @date: 2023/3/31
 **/
public class ShopUserRole implements Serializable {
    private Long userId;

    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
