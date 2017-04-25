package com.github.xuzw.api_engine_runtime.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.github.xuzw.api_engine_runtime.api.ResponseCode;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午1:39:52
 */
public class ApiExecuteException extends Exception {
    private static final long serialVersionUID = 1L;
    private static final String format = "(%d) %s";
    private final int code;
    private final String message;

    public ApiExecuteException(int code, String message) {
        super(String.format(format, code, message));
        this.code = code;
        this.message = message;
    }

    public ApiExecuteException(ResponseCode responseCode) {
        this(responseCode.getCode(), responseCode.getMessage());
    }

    public ApiExecuteException(ResponseCode responseCode, String overrideMessage) {
        this(responseCode.getCode(), overrideMessage);
    }

    public ApiExecuteException(ResponseCode responseCode, Throwable e) {
        this(responseCode.getCode(), ExceptionUtils.getMessage(e));
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
