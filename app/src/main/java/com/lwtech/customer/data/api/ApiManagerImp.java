package com.lwtech.customer.data.api;

import com.lwtech.customer.bean.ResponseData;
import com.lwtech.customer.bean.Template;
import com.lwtech.customer.data.rxjava.RxManager;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Jarly
 * Time :2017/11/9
 * Description:
 */
@Singleton
public class ApiManagerImp implements ApiManager {
    private TemplateApi templateApi;
    private RxManager rxManager;
    @Inject
    public ApiManagerImp(@Named("mock") TemplateApi templateApi,RxManager rxManager) {
        this.templateApi = templateApi;
        this.rxManager = rxManager;
    }

    @Override
    public Observable<ResponseData<Template>> login(String phone, String password) {
        return templateApi.login(phone, password)
                .compose(rxManager.applyScheduler())
                .compose(rxManager.extraDatas());
    }

    
}
