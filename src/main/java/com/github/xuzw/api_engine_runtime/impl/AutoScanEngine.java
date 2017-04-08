package com.github.xuzw.api_engine_runtime.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.xuzw.api_engine_runtime.annotation.ApiAnnotation;
import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.ApiWrapper;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.api.SimpleRequest;
import com.github.xuzw.api_engine_runtime.api.SimpleResponse;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.matchprocessor.ImplementingClassMatchProcessor;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午5:27:36
 */
public class AutoScanEngine extends SimpleEngine {
    private Logger logger = LoggerFactory.getLogger(AutoScanEngine.class);

    public AutoScanEngine(String... scanSpec) {
        new FastClasspathScanner(scanSpec).matchClassesImplementing(Api.class, new ImplementingClassMatchProcessor<Api>() {

            @Override
            public void processMatch(Class<? extends Api> apiClass) {
                String apiName = apiClass.getSimpleName();
                Class<?> requestClass = SimpleRequest.class;
                Class<?> responseClass = SimpleResponse.class;
                for (Class<?> innerClass : apiClass.getDeclaredClasses()) {
                    if (Request.class.isAssignableFrom(innerClass)) {
                        requestClass = innerClass;
                    } else if (Response.class.isAssignableFrom(innerClass)) {
                        responseClass = innerClass;
                    }
                }
                ApiAnnotation apiAnnotation = apiClass.getAnnotation(ApiAnnotation.class);
                if (apiAnnotation != null && StringUtils.isNotBlank(apiAnnotation.value())) {
                    apiName = apiAnnotation.value();
                }
                if (apiAnnotation != null && apiAnnotation.requestClass() != SimpleRequest.class) {
                    requestClass = apiAnnotation.requestClass();
                }
                if (apiAnnotation != null && apiAnnotation.responseClass() != SimpleResponse.class) {
                    requestClass = apiAnnotation.responseClass();
                }
                logger.info("setApi, name={}, apiClass={}, requestClass={}, responseClass={}", apiName, apiClass.getName(), requestClass.getName(), responseClass.getName());
                try {
                    setApi(apiName, new ApiWrapper(apiClass.newInstance(), requestClass, responseClass));
                } catch (InstantiationException | IllegalAccessException e) {
                    logger.error("", e);
                }
            }
        }).scan();
    }
}
