package com.github.xuzw.api_engine_runtime.api;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午5:09:29
 */
public class ApiWrapper {
    private Api api;
    private Class<?> requestClass;
    private Class<?> responseClass;

    public ApiWrapper(Api api, Class<?> requestClass, Class<?> responseClass) {
        this.api = api;
        this.requestClass = requestClass;
        this.responseClass = responseClass;
    }

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }

    public Class<?> getRequestClass() {
        return requestClass;
    }

    public void setRequestClass(Class<?> requestClass) {
        this.requestClass = requestClass;
    }

    public Class<?> getResponseClass() {
        return responseClass;
    }

    public void setResponseClass(Class<?> responseClass) {
        this.responseClass = responseClass;
    }
}
