package com.lwtech.customer.data.api;

import com.lwtech.customer.bean.ResponseData;
import com.lwtech.customer.bean.Template;

import io.reactivex.Observable;
import retrofit2.adapter.rxjava2.Result;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jarly
 * Time :2017/11/8
 * Description:
 */

public interface TemplateApi {

    @GET
    Observable<Result<ResponseData<Template>>> login(@Query ("phone") String phone,
                                                           @Query ("password") String password);
}
