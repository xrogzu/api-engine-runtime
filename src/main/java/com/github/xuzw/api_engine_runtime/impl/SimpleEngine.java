package com.github.xuzw.api_engine_runtime.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.xuzw.api_engine_runtime.Engine;
import com.github.xuzw.api_engine_runtime.api.ApiEngineResponseCodeEnum;
import com.github.xuzw.api_engine_runtime.api.ApiWrapper;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_runtime.exception.ApiExecuteException;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午1:32:43
 */
public class SimpleEngine implements Engine {
    private Map<String, ApiWrapper> map = new HashMap<>();

    @Override
    public List<String> getApiNames() {
        return new ArrayList<>(map.keySet());
    }

    @Override
    public void setApi(String name, ApiWrapper apiWrapper) {
        map.put(name, apiWrapper);
    }

    @Override
    public ApiWrapper getApiWrapper(String name) {
        return map.get(name);
    }

    @Override
    public Response execute(Request request) throws ApiExecuteException {
        try {
            request.setExecuteByEngineTimestamp(System.currentTimeMillis());
            Response response = getApiWrapper(request.getApiName()).getApi().execute(request);
            response.setOverByEngineTimestamp(System.currentTimeMillis());
            return response;
        } catch (ApiExecuteException e) {
            throw e;
        } catch (Throwable e) {
            throw new ApiExecuteException(ApiEngineResponseCodeEnum.api_execute_exception, e);
        }
    }
}
