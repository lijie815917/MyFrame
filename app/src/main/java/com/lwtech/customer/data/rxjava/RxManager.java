package com.lwtech.customer.data.rxjava;

import com.lwtech.customer.bean.ResponseData;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.Result;

/**
 * Created by Jarly
 * Time :2017/11/8
 * Description:
 */

public class RxManager {

    /**
     * 线程切换
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> applyScheduler() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread(), true)
                .share();
    }

    public static <T> ObservableTransformer<T, T> applyScheduler(boolean isBackground) {
        return upstream -> {
            if (isBackground) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .share();
            } else {
                return upstream.subscribeOn(Schedulers.io())
                        .share();
            }
        };


    }

    /**
     * 多种可能出现的网络问题
     *
     * @param <R>
     * @param <T>
     * @return
     */
    public static <R, T extends Result<ResponseData<R>>> ObservableTransformer<T, ResponseData<R>> extraDatas() {
        return upstream -> upstream.flatMap(result -> {
            if (result.isError()) {
                return Observable.error(result.error());
            }

            //HTTP 错误
            final Response<ResponseData<R>> response = result.response();
            if (!result.response().isSuccessful()) {
                return Observable.error(new HttpException(response));
            }

            //服务器错误
            ResponseData<R> responseData = response.body();
            if (responseData.isFail()) {
                return Observable.error(new ApiException(responseData));
            }

            //正常返回
            return Observable.just(result.response().body());
        });
    }


    /**
     * 对数据进行判空处理
     *
     * @param <R>
     * @param <T>
     * @return
     */
    public static <R, T extends ResponseData<R>> ObservableTransformer<T, R> checkNot() {
        return upstream -> upstream.flatMap(t -> {
            if (t.getData() == null) {
                return Observable.error(new ApiException(ApiException.CODE_NO_DATA, "获取数据失败"));
            }
            return Observable.just(t.getData());
        });
    }

    /**
     * 判断List不为空
     *
     * @param <R>
     * @param <T>
     * @return
     */
    public static <R, T extends ResponseData<List<R>>> ObservableTransformer<T, List<R>> emptyIfNullList() {
        return upstream -> upstream.map(t -> {
            if (t.getData() == null) {
                Collections.emptyList();
            }
            return t.getData();
        });
    }
}

