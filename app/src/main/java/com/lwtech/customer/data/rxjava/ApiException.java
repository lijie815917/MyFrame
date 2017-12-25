package com.lwtech.customer.data.rxjava;

import com.lwtech.customer.bean.ResponseData;

/**
 * 接口异常
 * Created by chenrong on 2017/9/27.
 */
public class ApiException extends Exception {

    //错误代码，Custom或ResponseParser返回
    private int mCode;

    //无数据
    public static final int CODE_NO_DATA = -10000;
    //无网络
    public static final int CODE_NO_NET = -10001;

    public ApiException(ResponseData responseData) {
        super(responseData.getMsg());
        mCode = responseData.getCode();
    }

    public ApiException(int code, String message) {
        super(message);
        mCode = code;
    }

    public int getCode() {
        return mCode;
    }
}
