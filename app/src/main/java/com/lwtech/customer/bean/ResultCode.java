package com.lwtech.customer.bean;

/**
 * Created by Jarly
 * Time :2017/10/26
 * Description:
 */

public class ResultCode {
    /**
     * 请求成功
     */
    public static final int SUCCESS = 200;

    /**
     * 签名错误
     */
    public static final int SIGN_ERROR = 2010;

    /**
     * token鉴权错误
     */
    public static final int TOKEN_ERROR = 2020;

    /**
     * 登录验证码错误
     */
    public static final int CODE_FAILED = 400;
}
