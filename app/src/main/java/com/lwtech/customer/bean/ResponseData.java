package com.lwtech.customer.bean;

/**
 * Created by Jarly
 * Time :2017/11/8
 * Description:
 */

public class ResponseData<T> {

    private int code;
    private String msg;
    private T data;

    public ResponseData() {
    }

    public ResponseData(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSucceed() {
        return code == ResultCode.SUCCESS;
    }

    public boolean isFail() {
        return !isSucceed();
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
}
