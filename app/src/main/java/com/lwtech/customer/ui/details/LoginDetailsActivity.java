package com.lwtech.customer.ui.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.lwtech.customer.R;
import com.lwtech.customer.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jarly
 * Time :2017/11/9
 * Description:
 */

public class LoginDetailsActivity extends BaseActivity implements LoginDetailsContract.View {

    @BindView (R.id.tv_show) TextView tvShow;
    @Inject LoginDetailsPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_login_details);
        ButterKnife.bind(this);
        presenter.setView(this);
        presenter.setRxLife(this);
        presenter.getDetails("1", "2");
    }


    @Override
    public void showDetails(String details) {
        tvShow.setText(details);
    }
}
