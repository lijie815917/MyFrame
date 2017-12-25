package com.lwtech.customer.data.api;

import com.lwtech.customer.bean.ResponseData;
import com.lwtech.customer.bean.Template;

import io.reactivex.Observable;

/**
 * Created by Jarly
 * Time :2017/11/9
 * Description:
 */

public interface ApiManager {
    Observable<ResponseData<Template>> login(String phone,String password);
}
