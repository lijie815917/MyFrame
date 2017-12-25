package com.lwtech.customer.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.lwtech.customer.di.component.FragmentComponent;
import com.lwtech.customer.di.inject.ObjectGragh;

/**
 * Created by Jarly
 * Time :2017/11/9
 * Description:
 */

public class BaseFragment extends Fragment {
    private FragmentComponent fragmentComponent;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragmentInjector();
    }

    private void initFragmentInjector(){
        fragmentComponent = ObjectGragh.create(this);
        fragmentComponent.inject(this);
    }

    protected FragmentComponent getFragmentComponent(){
        return fragmentComponent;
    }
}
