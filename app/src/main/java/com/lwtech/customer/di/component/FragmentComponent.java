package com.lwtech.customer.di.component;
import com.lwtech.customer.base.BaseFragment;
import com.lwtech.customer.di.annotation.PerFragment;
import com.lwtech.customer.di.module.FragmentModule;


import dagger.Component;

/**
 * Created by Jarly
 * Time :2017/11/8
 * Description:
 */
@PerFragment
@Component (dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(BaseFragment baseFragment);
}
