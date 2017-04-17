package com.github.xuzw.api_engine_runtime.api;

import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午12:51:01
 */
public class Response {
    @Comment("API接口名字") @Required(true) private String apiName;
    @Comment("请求唯一标识符") @Required(true) private String requestUuid;
    @Comment("错误码") @Required(true) private int code = ResponseCode.success;
    @Comment("错误提示") @Required(false) private String message;
    @Comment("请求被服务器处理完毕的时间戳") @Required(true) private long overByEngineTimestamp;

    public void success() {
        this.code = ResponseCode.success;
    }

    public void error(int code, String message) {
        if (code == ResponseCode.success) {
            code = ResponseCode.api_execute_exception;
        }
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
