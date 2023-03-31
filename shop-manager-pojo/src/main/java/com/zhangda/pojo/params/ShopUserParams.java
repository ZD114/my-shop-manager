package com.zhangda.pojo.params;

import com.zhangda.common.PageParam;

/**
 * 用户查询参数
 *
 * @author zhangda
 * @date: 2023/3/31
 **/
public class ShopUserParams extends PageParam {
    private String username;

    private String nickname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
