package com.zhangda.common.constant.annotation;

import java.lang.annotation.*;

/**
 * 自动生成当前用户, 用于数据更新时自动赋值
 *
 * @author zhangda
 * @date: 2023/4/27
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Documented
public @interface AutoUserOnUpdate {

    String value() default "";
}
