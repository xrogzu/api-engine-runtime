package com.github.xuzw.api_engine_runtime;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午1:35:38
 */
public class ApiNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ApiNotFoundException(String name) {
        super(name);
    }
}
