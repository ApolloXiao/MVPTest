package com.apollo.mvptest.model.http.exception;

/**
 * Created by lei.xiao on 2018/2/6.
 */

public class ApiException extends Exception {
    private int code;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
