package com.github.xuzw.api_engine_runtime.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月2日 上午11:42:30
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface ModelAnnotation {
}
