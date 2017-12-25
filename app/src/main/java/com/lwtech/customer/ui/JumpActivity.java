package com.lwtech.customer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.lwtech.customer.R;
import com.lwtech.customer.base.BaseActivity;
import com.lwtech.customer.bean.ResponseData;
import com.lwtech.customer.bean.Template;
import com.lwtech.customer.data.rxjava.LifeCycle;
import com.lwtech.customer.data.rxjava.RxManager;
import com.lwtech.customer.data.rxjava.RxObserver;
import com.lwtech.customer.ui.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;

/**
 * Created by Jarly
 * Time :2017/11/9
 * Description:MV传统写法
 */

public class JumpActivity extends BaseActivity {

    @BindView (R.id.btn_jump) Button btnJump;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        getActivityComponent().inject(this);//可以直接通过父类暴露apiManager
        setContentView(R.layout.test);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.btn_jump)
    public void setBtnJump() {
        apiManager.login("1", "2")
                .compose(bindLife(LifeCycle.DESTROY))
                .subscribe(new RxObserver<ResponseData<Template>>() {
                    @Override
                    public void onNext(@NonNull ResponseData<Template> templateResponseData) {
                        super.onNext(templateResponseData);
                        Log.e(getPackageName(), templateResponseData.getMsg());

                        Toast.makeText(JumpActivity.this, templateResponseData.getMsg(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(JumpActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        super.onError(e);
                        Log.e(getPackageName(), e.getMessage());
                    }
                });
    }
}
