package com.lwtech.customer.data.rxjava;

import io.reactivex.ObservableTransformer;

/**
 * Created by Jarly
 * Time :2017/12/11
 * Description:
 */

public interface RxLifeProvider {
    <T> ObservableTransformer<T, T> bindLife(LifeCycle lifeCycle);
}
