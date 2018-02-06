package com.apollo.mvptest.model.http.response;

/**
 * Created by lei.xiao on 2018/2/6.
 */

public class HttpResponse<T> {
    private int code;
    private String msg;
    private T data;

    public HttpResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
