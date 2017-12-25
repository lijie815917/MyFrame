package com.lwtech.customer;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.lwtech.customer.di.component.AppComponent;
import com.lwtech.customer.di.inject.ObjectGragh;

/**
 * Created by Jarly
 * Time :2017/11/8
 * Description:
 */

public class LWApp extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initInAppjector();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

    }

    private void initInAppjector() {
        appComponent = ObjectGragh.create(this);
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
