package com.lwtech.customer.ui.login;

import android.util.Log;
import android.widget.Toast;

import com.lwtech.customer.base.BaseView;
import com.lwtech.customer.bean.ResponseData;
import com.lwtech.customer.bean.Template;
import com.lwtech.customer.data.api.ApiManager;
import com.lwtech.customer.data.api.TemplateApi;
import com.lwtech.customer.data.rxjava.LifeCycle;
import com.lwtech.customer.data.rxjava.RxLifeProvider;
import com.lwtech.customer.data.rxjava.RxManager;
import com.lwtech.customer.data.rxjava.RxObserver;
import com.lwtech.customer.di.annotation.PerActivity;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.annotations.NonNull;

/**
 * Created by Jarly
 * Time :2017/11/9
 * Description:
 */

@PerActivity
public class LoginPresenter implements LoginContract.Presenter {
    private TemplateApi templateApi;
    private RxManager rxManager;
    private LoginContract.View loginView;
    private ApiManager apiManager;
    private RxLifeProvider provider;

    @Inject
    public LoginPresenter(@Named ("mock") TemplateApi templateApi) {
        this.templateApi = templateApi;
    }

    @Override
    public void login(String phone, String password) {
        templateApi.login(phone, password)
                .compose(RxManager.applyScheduler())
                .compose(RxManager.extraDatas())
                .compose(provider.bindLife(LifeCycle.PAUSE))
                .subscribe(new RxObserver<ResponseData<Template>>() {
                    @Override
                    public void onNext(@NonNull ResponseData<Template> templateResponseData) {
                        super.onNext(templateResponseData);
                        Log.e(getClass().getName(), templateResponseData.getMsg());

                        loginView.showTips(templateResponseData.getMsg());
                        loginView.loginSuccess();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        super.onError(e);
                        loginView.showTips(e.getMessage());
                    }
                });


    }

    //    @Inject
    //    public LoginPresenter(ApiManager apiManager) {
    //        this.apiManager = apiManager;
    //    }
    //
    //    @Override
    //    public void login(String phone, String password) {
    //        apiManager.login(phone, password)
    //                .subscribe(new RxObserver<ResponseData<Template>>() {
    //                    @Override
    //                    public void onNext(@NonNull ResponseData<Template> templateResponseData) {
    //                        super.onNext(templateResponseData);
    //                        loginView.showTips(templateResponseData.getMsg());
    //                        loginView.loginSuccess();
    //                    }
    //
    //                    @Override
    //                    public void onError(@NonNull Throwable e) {
    //                        super.onError(e);
    //                        loginView.showTips(e.getMessage());
    //                    }
    //                });
    //
    //
    //    }


    @Override
    public void setView(LoginContract.View view) {
        loginView = view;
    }

    @Override
    public void setRxLife(RxLifeProvider provider) {
        this.provider = provider;
    }
}
