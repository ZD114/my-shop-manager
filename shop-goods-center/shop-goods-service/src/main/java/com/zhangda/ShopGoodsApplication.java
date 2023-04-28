package com.zhangda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangda
 * @date: 2023/4/28
 **/
@SpringBootApplication
public class ShopGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopGoodsApplication.class, args);
        System.out.println("***********************************************************");
        System.out.println("商品服务启动完成...");
        System.out.println("***********************************************************");
    }
}
