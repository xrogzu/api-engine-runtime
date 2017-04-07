package com.github.xuzw.api_engine_runtime.exception;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午1:39:52
 */
public class ApiExecuteException extends Exception {
    private static final long serialVersionUID = 1L;
    private static final String format = "(%d) %s";
    private int code;
    private String message;

    public ApiExecuteException(int code, String message) {
        super(String.format(format, code, message));
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
