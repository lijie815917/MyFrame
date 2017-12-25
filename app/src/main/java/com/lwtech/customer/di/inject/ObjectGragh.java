package com.lwtech.customer.di.inject;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.lwtech.customer.LWApp;
import com.lwtech.customer.di.component.ActivityComponent;
import com.lwtech.customer.di.component.AppComponent;
import com.lwtech.customer.di.component.DaggerActivityComponent;
import com.lwtech.customer.di.component.DaggerAppComponent;
import com.lwtech.customer.di.component.DaggerFragmentComponent;
import com.lwtech.customer.di.component.FragmentComponent;
import com.lwtech.customer.di.module.ActivityModule;
import com.lwtech.customer.di.module.ApiModule;
import com.lwtech.customer.di.module.AppModule;
import com.lwtech.customer.di.module.FragmentModule;

/**
 * Created by Jarly
 * Time :2017/11/9
 * Description:
 */

public class ObjectGragh {

    public static AppComponent create(LWApp lwApp) {
        return DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .appModule(new AppModule(lwApp))
                .build();
    }

    public static ActivityComponent create(Activity activity) {
        AppComponent appComponent = ((LWApp) activity.getApplication()).getAppComponent();
        return DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(new ActivityModule(activity))
                .build();
    }


    public static FragmentComponent create(Fragment fragment) {
        LWApp lwApp = (LWApp) fragment.getActivity().getApplication();
       return DaggerFragmentComponent.builder()
                .appComponent(lwApp.getAppComponent())
                .fragmentModule(new FragmentModule(fragment))
                .build();
    }
}
