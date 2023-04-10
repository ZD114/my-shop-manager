package com.zhangda.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 密码算法
 * @author zhangda
 * @date: 2023/4/10
 **/
public class Encrypt {
    public static String md5(String password, String salt){
        return new Md5Hash(password,salt,10).toString();
    }
}
