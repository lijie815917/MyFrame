package com.lwtech.customer.di.module;

import com.lwtech.customer.data.api.ApiManager;
import com.lwtech.customer.data.api.ApiManagerImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jarly
 * Time :2017/11/9
 * Description:
 */
@Module
public class DataModule {

    @Singleton
    @Provides
    ApiManager provideApiManager(ApiManagerImp apiManagerImp) {
        return apiManagerImp;
    }
}
