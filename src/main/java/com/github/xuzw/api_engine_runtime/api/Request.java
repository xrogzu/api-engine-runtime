package com.github.xuzw.api_engine_runtime.api;

import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午12:50:42
 */
public class Request {
    @Comment("API接口名字") @Required(true) private String apiName;
    @Comment("请求唯一标识符") @Required(false) private String uuid;
    @Comment("请求发送时间") @Required(false) private long sendToEngineTimestamp;
    @Comment("请求被服务器开始处理的时间戳") @Required(false) private long executeByEngineTimestamp;

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
