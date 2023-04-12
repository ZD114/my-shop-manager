package com.zhangda.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户角色中间表
 *
 * @author zhangda
 * @date: 2023/3/31
 **/
public class ShopUserRole implements Serializable {
    private Long userId;

    private Long roleId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
