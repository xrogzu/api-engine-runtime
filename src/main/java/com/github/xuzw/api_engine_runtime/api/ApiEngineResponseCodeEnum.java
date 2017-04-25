package com.github.xuzw.api_engine_runtime.api;

/**
 * 接口引擎响应码枚举, 保留范围0~999
 * 
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月25日 下午3:42:33
 */
public enum ApiEngineResponseCodeEnum implements ResponseCode {
    /**
     * 成功
     */
    success(0, "成功"),
    /**
     * API未找到
     */
    api_not_found_exception(1, "API未找到"),
    /**
     * API执行异常
     */
    api_execute_exception(2, "API执行异常");

    private final int code;
    private final String message;

    private ApiEngineResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override()
    public int getCode() {
        return code;
    }

    @Override()
    public String getMessage() {
        return message;
    }
}
