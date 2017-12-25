package com.lwtech.customer.di.component;

import com.lwtech.customer.LWApp;
import com.lwtech.customer.data.api.ApiManager;
import com.lwtech.customer.data.api.ApiManagerImp;
import com.lwtech.customer.data.api.TemplateApi;
import com.lwtech.customer.data.rxjava.RxManager;
import com.lwtech.customer.di.module.ApiModule;
import com.lwtech.customer.di.module.AppModule;
import com.lwtech.customer.di.module.DataModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Jarly
 * Time :2017/11/8
 * Description:
 */
@Singleton
@Component (modules = {AppModule.class, ApiModule.class, DataModule.class})
public interface AppComponent {
    LWApp provideApp();

    @Named("mock")
    TemplateApi provideTemplateApi();

    ApiManager provideApiManager();

    RxManager provideRxManager();

    void inject(LWApp lwApp);

}
