package com.lwtech.customer.di.module;

import com.lwtech.customer.LWApp;
import com.lwtech.customer.data.rxjava.RxManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jarly
 * Time :2017/11/8
 * Description:
 */
@Module
public class AppModule {
    private final LWApp lwApp;

    public AppModule(LWApp lwApp) {
        this.lwApp = lwApp;
    }

    @Singleton
    @Provides
    LWApp provideApp() {
        return this.lwApp;
    }

    @Singleton
    @Provides RxManager provideRxManager(){
        return new RxManager();
    }
}
