package com.github.xuzw.api_engine_runtime.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午5:21:26
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface Api {
    String name();

    Class<?> requestClass();

    Class<?> responseClass();
}
