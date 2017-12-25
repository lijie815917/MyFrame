package com.lwtech.customer.base;

import com.lwtech.customer.data.rxjava.RxLifeProvider;

/**
 * Created by Jarly
 * Time :2017/11/9
 * Description:
 */

public interface BasePresenter<T extends BaseView>{
    void setView (T view);
    void setRxLife(RxLifeProvider provider);
}
