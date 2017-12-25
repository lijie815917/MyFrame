package com.lwtech.customer.data.mock;

import com.lwtech.customer.bean.ResponseData;
import com.lwtech.customer.bean.Template;
import com.lwtech.customer.data.api.TemplateApi;

import io.reactivex.Observable;
import retrofit2.adapter.rxjava2.Result;
import retrofit2.http.Query;
import retrofit2.mock.BehaviorDelegate;

/**
 * Created by Jarly
 * Time :2017/11/9
 * Description:
 */

public class MockTemplateApi implements TemplateApi {
    private final BehaviorDelegate<TemplateApi> delegate;

    public MockTemplateApi(BehaviorDelegate<TemplateApi> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Observable<Result<ResponseData<Template>>> login(@Query ("phone") String phone, @Query ("password") String password) {
        Template template = new Template("lijie",11);
        template.setHeight(10);
        template.setName("这是测试数据");
        ResponseData<Template> responseData = new ResponseData<>(200, "这是测试数据", template);
        return delegate.returningResponse(responseData).login("1371039023", "123456");
    }
}
