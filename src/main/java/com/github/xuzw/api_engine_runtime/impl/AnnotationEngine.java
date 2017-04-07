package com.github.xuzw.api_engine_runtime.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.xuzw.api_engine_runtime.annotation.ApiAnnotation;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.ApiWrapper;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.matchprocessor.ClassAnnotationMatchProcessor;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午5:27:36
 */
public class AnnotationEngine extends SimpleEngine {
    private Logger logger = LoggerFactory.getLogger(AnnotationEngine.class);

    public AnnotationEngine() {
        new FastClasspathScanner().matchClassesWithAnnotation(ApiAnnotation.class, new ClassAnnotationMatchProcessor() {
            @Override
            public void processMatch(Class<?> classWithAnnotation) {
                ApiAnnotation apiAnnotation = classWithAnnotation.getAnnotation(ApiAnnotation.class);
                try {
                    Api apiInstance = (Api) classWithAnnotation.newInstance();
                    Class<?> requestClass = apiAnnotation.requestClass();
                    Class<?> responseClass = apiAnnotation.responseClass();
                    logger.info("setApi, api={}, requestClass={}, responseClass={}", apiInstance, requestClass, responseClass);
                    setApi(apiAnnotation.name(), new ApiWrapper(apiInstance, requestClass, responseClass));
                } catch (InstantiationException | IllegalAccessException e) {
                    logger.error("", e);
                }
            }
        }).scan();
    }
}