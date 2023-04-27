package com.zhangda.common.constant.annotation;

import java.lang.annotation.*;

/**
 * 自动生成用户ID, 用于数据更新时
 *
 * @author zhangda
 * @date: 2023/4/27
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Documented
public @interface AutoUserIdOnUpdate {

    String value() default "";
}
