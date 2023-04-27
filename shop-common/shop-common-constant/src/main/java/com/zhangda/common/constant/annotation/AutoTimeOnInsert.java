package com.zhangda.common.constant.annotation;

import java.lang.annotation.*;

/**
 * 自动生成时间, 用于数据新增时
 *
 * @author zhangda
 * @date: 2023/4/27
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
public @interface AutoTimeOnInsert {
    String value() default "";
}
