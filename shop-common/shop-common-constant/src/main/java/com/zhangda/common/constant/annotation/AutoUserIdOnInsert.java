package com.zhangda.common.constant.annotation;

import java.lang.annotation.*;

/**
 * 自动生成用户ID, 用于数据新增时
 *
 * @author zhangda
 * @date: 2023/4/27
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Documented
public @interface AutoUserIdOnInsert {

    String value() default "";
}
