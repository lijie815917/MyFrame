package com.lwtech.customer.data.rxjava;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Jarly
 * Time :2017/8/22
 * Description:
 * contact:13710397702&&848287246@qq.com
 */

public class RxObserver<T> implements Observer<T> {
    private Disposable disposable;

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        disposable = d;
    }

    @Override
    public void onNext(@NonNull T t) {

    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    //取消订阅
    public void dispose() {
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
