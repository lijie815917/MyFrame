package com.lwtech.customer.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lwtech.customer.LWApp;
import com.lwtech.customer.data.api.ApiManager;
import com.lwtech.customer.data.rxjava.LifeCycle;
import com.lwtech.customer.data.rxjava.RxLifeProvider;
import com.lwtech.customer.di.component.ActivityComponent;
import com.lwtech.customer.di.component.DaggerActivityComponent;
import com.lwtech.customer.di.inject.ObjectGragh;
import com.lwtech.customer.di.module.ActivityModule;

import io.reactivex.ObservableTransformer;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Jarly
 * Time :2017/11/9
 * Description:
 */

public class BaseActivity extends AppCompatActivity implements RxLifeProvider {
    private ActivityComponent activityComponent;
    protected ApiManager apiManager;
    private BehaviorSubject<LifeCycle> behaviorSubject = BehaviorSubject.create();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityInjector();
        apiManager = ((LWApp) getApplication()).getAppComponent().provideApiManager();
    }

    private void initActivityInjector() {
        activityComponent = ObjectGragh.create(this);
        activityComponent.inject(this);
    }

    protected ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    @Override
    protected void onResume() {
        super.onResume();
        behaviorSubject.onNext(LifeCycle.RESUME);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        behaviorSubject.onNext(LifeCycle.DESTROY);
    }


    @Override
    protected void onPause() {
        super.onPause();
        behaviorSubject.onNext(LifeCycle.PAUSE);
    }


    @Override
    public <T> ObservableTransformer<T, T> bindLife(LifeCycle lifeCycle) {
        return upstream -> upstream.takeUntil(behaviorSubject.skipWhile(life -> !life.equals(lifeCycle))).take(1);
    }
}
