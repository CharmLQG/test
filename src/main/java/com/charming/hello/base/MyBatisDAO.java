package com.charming.hello.base;

import java.lang.annotation.*;

/**
 * @author 杨水美
 * @version 2019-03-23
 * DAO注解
 * 需要配合org.mybatis.spring.mapper.MapperScannerConfigurer使用
 * 正常情况下不需要该注解标识DAO类
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface MyBatisDAO {
    String value() default "";
}
