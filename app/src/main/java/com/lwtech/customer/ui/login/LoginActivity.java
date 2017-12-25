package com.lwtech.customer.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lwtech.customer.R;
import com.lwtech.customer.base.BaseActivity;
import com.lwtech.customer.ui.details.LoginDetailsActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jarly
 * Time :2017/11/9
 * Description:
 */

public class LoginActivity extends BaseActivity implements LoginContract.View {


    @BindView (R.id.edt_phone) EditText edtPhone;
    @BindView (R.id.edt_psw) EditText edtPsw;
    @BindView (R.id.btn_login) Button btnLogin;
    @Inject LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter.setView(this);
        loginPresenter.setRxLife(this);
    }

    @OnClick (R.id.btn_login)
    public void setOnLogin() {
        String phone = edtPhone.getText().toString();
        String password = edtPsw.getText().toString();
        loginPresenter.login(phone, password);
    }

    @Override
    public void showTips(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(this, LoginDetailsActivity.class);
        startActivity(intent);
        Log.e(getPackageName(), "success");
    }

}
