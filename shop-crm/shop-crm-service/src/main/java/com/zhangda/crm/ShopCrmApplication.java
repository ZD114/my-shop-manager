package com.zhangda.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangda
 * @date: 2023/5/29
 **/
@SpringBootApplication
public class ShopCrmApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopCrmApplication.class, args);
        System.out.println("***********************************************************");
        System.out.println("crm服务启动完成...");
        System.out.println("***********************************************************");
    }
}
