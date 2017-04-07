package com.github.xuzw.api_engine_runtime.api;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午12:51:01
 */
public abstract class Response {
    private String apiName;
    private String requestUuid;
    private int code;
    private String message;
    private long overByEngineTimestamp;

    public void success() {
        this.code = 0;
    }

    public void success(String message) {
        this.code = 0;
        this.message = message;
    }

    public void error(int code) {
        this.code = code;
    }

    public void error(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getRequestUuid() {
        return requestUuid;
    }

    public void setRequestUuid(String requestUuid) {
        this.requestUuid = requestUuid;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getOverByEngineTimestamp() {
        return overByEngineTimestamp;
    }

    public void setOverByEngineTimestamp(long overByEngineTimestamp) {
        this.overByEngineTimestamp = overByEngineTimestamp;
    }
}
