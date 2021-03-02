package com.haiziwang.commodity.annotation;

import com.haiziwang.commodity.common.Constant;

import java.lang.annotation.*;

/**
 * 自定义数据源注解
 */
@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceTypeAnnotation {
    String value() default Constant.DATASOURCE_CONVERSION;
}
