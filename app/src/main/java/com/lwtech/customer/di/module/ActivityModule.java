package com.lwtech.customer.di.module;

import android.app.Activity;
import android.content.Context;

import com.lwtech.customer.di.annotation.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jarly
 * Time :2017/11/8
 * Description:
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return this.activity;
    }

    @Provides
    @PerActivity
    Context provideContext() {
        return this.activity;
    }


}
