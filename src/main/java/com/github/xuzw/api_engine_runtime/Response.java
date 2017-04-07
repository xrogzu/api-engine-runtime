package com.github.xuzw.api_engine_runtime;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午12:51:01
 */
public abstract class Response {
    private String apiName;
    private long overByEngineTimestamp;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public long getOverByEngineTimestamp() {
        return overByEngineTimestamp;
    }

    public void setOverByEngineTimestamp(long overByEngineTimestamp) {
        this.overByEngineTimestamp = overByEngineTimestamp;
    }
}
