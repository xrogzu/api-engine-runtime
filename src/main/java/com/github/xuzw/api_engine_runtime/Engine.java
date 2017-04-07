package com.github.xuzw.api_engine_runtime;

import java.util.List;

import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.exception.ApiExecuteException;
import com.github.xuzw.api_engine_runtime.exception.ApiNotFoundException;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午12:47:11
 */
public interface Engine {
    List<String> getApiNames();

    boolean hasApi(String name);

    void setApi(String name, Api api);

    Response execute(Request request) throws ApiNotFoundException, ApiExecuteException;
}
