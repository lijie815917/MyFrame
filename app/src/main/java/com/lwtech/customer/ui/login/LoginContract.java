package com.lwtech.customer.ui.login;

import com.lwtech.customer.base.BasePresenter;
import com.lwtech.customer.base.BaseView;

/**
 * Created by Jarly
 * Time :2017/11/9
 * Description:
 */

public interface LoginContract {
    interface View extends BaseView {
        void showTips(String msg);

        void loginSuccess();

    }

    interface Presenter extends BasePresenter<View> {
        void login(String phone, String password);
    }
}
