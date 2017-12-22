package com.xuekai.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author shixuekai
 * @CreateDate 2017/12/22
 * @Description
 **/
@Retention(RetentionPolicy.RUNTIME)//在jvm的驻留时间
@Target({ElementType.METHOD})//拦截目标区域
public @interface Logrecord {
}
