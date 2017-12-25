package com.lwtech.customer.ui.details;

import com.lwtech.customer.base.BasePresenter;
import com.lwtech.customer.base.BaseView;

import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Jarly
 * Time :2017/11/9
 * Description:
 */

public interface LoginDetailsContract {

    interface View extends BaseView{
         void showDetails(String details);
    }

    interface Presenter extends BasePresenter<View>{
        void getDetails(String phone,String psw);
    }
}
