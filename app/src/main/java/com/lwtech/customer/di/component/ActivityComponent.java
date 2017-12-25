package com.lwtech.customer.di.component;

import com.lwtech.customer.base.BaseActivity;
import com.lwtech.customer.di.annotation.PerActivity;
import com.lwtech.customer.di.module.ActivityModule;
import com.lwtech.customer.ui.details.LoginDetailsActivity;
import com.lwtech.customer.ui.login.LoginActivity;

import dagger.Component;

/**
 * Created by Jarly
 * Time :2017/11/8
 * Description:
 */
@PerActivity
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(BaseActivity baseActivity);
    void inject(LoginActivity loginActivity);
    void inject(LoginDetailsActivity loginDetailsActivity);

}
