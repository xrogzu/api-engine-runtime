package com.github.xuzw.api_engine_runtime.api;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午12:51:21
 */
public interface Api {
    Response execute(Request request) throws Exception;
}
