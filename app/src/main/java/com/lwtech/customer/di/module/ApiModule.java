package com.lwtech.customer.di.module;

import com.lwtech.customer.BuildConfig;
import com.lwtech.customer.data.api.TemplateApi;
import com.lwtech.customer.data.json.DateAdapter;
import com.lwtech.customer.data.mock.MockTemplateApi;
import com.squareup.moshi.Moshi;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

/**
 * Created by Jarly
 * Time :2017/11/8
 * Description:
 */

@Module
public class ApiModule {

    private static final String PRODUCT_api_URL = "http://www.baidu.com";
    private static final boolean MOCK_ENABLE = false && BuildConfig.DEBUG;


    @Singleton
    @Provides
    @Named ("api")
    String provideURL() {
        return PRODUCT_api_URL;
    }

    @Singleton
    @Provides
    @Named ("api")
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);
        builder.connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS);
        return builder.build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(@Named ("api") String baseUrl, @Named ("api") OkHttpClient client, Moshi moshi) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi));
        return builder.build();
    }

    @Singleton
    @Provides
    Moshi provideMoshi() {
        Moshi.Builder builder = new Moshi.Builder();
        builder.add(new DateAdapter());
        return builder.build();

    }


    @Singleton
    @Provides
    MockRetrofit provideMockRetrofit(Retrofit retrofit) {
        MockRetrofit.Builder builder = new MockRetrofit.Builder(retrofit);
        NetworkBehavior networkBehavior = NetworkBehavior.create();
        networkBehavior.setDelay(2, TimeUnit.SECONDS);
        return builder.networkBehavior(networkBehavior).build();

    }

    @Singleton
    @Provides
    @Named ("mock")
    TemplateApi provideMockTemplateApi(MockRetrofit mockRetrofit) {
        return new MockTemplateApi(mockRetrofit.create(TemplateApi.class));
    }

    @Singleton
    @Provides
    TemplateApi provideTemplateApi(Retrofit retrofit) {
        return retrofit.create(TemplateApi.class);
    }


}
