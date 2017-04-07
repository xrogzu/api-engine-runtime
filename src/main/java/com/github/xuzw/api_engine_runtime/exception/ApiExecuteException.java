package com.github.xuzw.api_engine_runtime.exception;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午1:39:52
 */
public class ApiExecuteException extends Exception {
    private static final long serialVersionUID = 1L;

    public ApiExecuteException(String message) {
        super(message);
    }

    public ApiExecuteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiExecuteException(Throwable cause) {
        super(cause);
    }
}
