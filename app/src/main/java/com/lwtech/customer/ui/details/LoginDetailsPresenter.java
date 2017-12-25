package com.lwtech.customer.ui.details;

import android.util.Log;

import com.lwtech.customer.bean.ResponseData;
import com.lwtech.customer.bean.Template;
import com.lwtech.customer.data.api.ApiManager;
import com.lwtech.customer.data.rxjava.LifeCycle;
import com.lwtech.customer.data.rxjava.RxLifeProvider;
import com.lwtech.customer.data.rxjava.RxObserver;
import com.lwtech.customer.di.annotation.PerActivity;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created by Jarly
 * Time :2017/11/9
 * Description:
 */
@PerActivity
public class LoginDetailsPresenter implements LoginDetailsContract.Presenter {
    private ApiManager apiManager;
    private LoginDetailsContract.View detailsView;
    private RxLifeProvider provider;

    @Inject
    public LoginDetailsPresenter(ApiManager apiManager) {
        this.apiManager = apiManager;
    }

    @Override
    public void setView(LoginDetailsContract.View view) {
        this.detailsView = view;
    }

    @Override
    public void setRxLife(RxLifeProvider provider) {
        this.provider = provider;
    }

    @Override
    public void getDetails(String phone, String psw) {
        apiManager.login(phone, psw)
                .compose(provider.bindLife(LifeCycle.PAUSE))
                .subscribe(new RxObserver<ResponseData<Template>>() {
                    @Override
                    public void onNext(@NonNull ResponseData<Template> templateResponseData) {
                        super.onNext(templateResponseData);
                        int height = templateResponseData.getData().getHeight();
                        String name = templateResponseData.getData().getName();
                        String details = "姓名：" + name + "  身高：" + height;
                        detailsView.showDetails(details);
                        Log.e(getClass().getName(), templateResponseData.getMsg());

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        super.onError(e);
                        detailsView.showDetails(e.getMessage());
                    }
                });
    }

}
