package com.lwtech.customer.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import dagger.Module;


/**
 * Created by Jarly
 * Time :2017/11/8
 * Description:
 */
@Module
public class FragmentModule {
    private final Fragment fragment;

    public FragmentModule(Fragment fragment){
        this.fragment = fragment;
    }

}
