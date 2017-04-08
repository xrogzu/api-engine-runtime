package com.github.xuzw.api_engine_runtime.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.xuzw.api_engine_runtime.annotation.ApiAnnotation;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.ApiWrapper;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;

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
            public void processMatch(Class<?> apiClass) {
                ApiAnnotation apiAnnotation = apiClass.getAnnotation(ApiAnnotation.class);
                try {
                    Api apiInstance = (Api) apiClass.newInstance();
                    String apiName = apiAnnotation.name();
                    if (StringUtils.isBlank(apiName)) {
                        apiName = apiClass.getSimpleName();
                    }
                    Class<?> requestClass = apiAnnotation.requestClass();
                    Class<?> responseClass = apiAnnotation.responseClass();
                    for (Class<?> innerClass : apiClass.getDeclaredClasses()) {
                        if (Request.class.isAssignableFrom(innerClass)) {
                            requestClass = innerClass;
                        } else if (Response.class.isAssignableFrom(innerClass)) {
                            responseClass = innerClass;
                        }
                    }
                    logger.info("setApi, name={}, apiClass={}, requestClass={}, responseClass={}", apiName, apiClass.getName(), requestClass.getName(), responseClass.getName());
                    setApi(apiName, new ApiWrapper(apiInstance, requestClass, responseClass));
                } catch (InstantiationException | IllegalAccessException e) {
                    logger.error("", e);
                }
            }
        }).scan();
    }
}
