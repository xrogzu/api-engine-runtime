package com.github.xuzw.api_engine_runtime.api;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午12:50:42
 */
public class Request {
    private String apiName;
    private String uuid;
    private long sendToEngineTimestamp;
    private long executeByEngineTimestamp;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getSendToEngineTimestamp() {
        return sendToEngineTimestamp;
    }

    public void setSendToEngineTimestamp(long sendToEngineTimestamp) {
        this.sendToEngineTimestamp = sendToEngineTimestamp;
    }

    public long getExecuteByEngineTimestamp() {
        return executeByEngineTimestamp;
    }

    public void setExecuteByEngineTimestamp(long executeByEngineTimestamp) {
        this.executeByEngineTimestamp = executeByEngineTimestamp;
    }
}
