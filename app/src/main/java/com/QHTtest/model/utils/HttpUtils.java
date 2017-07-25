package com.QHTtest.model.utils;

import com.QHTtest.view.iview.ApiServer;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by 仇海涛 on 2017/7/13.
 * class ：
 * content ：
 */

public class HttpUtils {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constant.LINK_MAIN)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    //get封装
    public static void get(Consumer<String> onNext,Consumer<Throwable> onError, Map<String,String> map,String url){
        ApiServer api = retrofit.create(ApiServer.class);
        Observable<String> observable = api.getTest(url,map);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(onNext,onError);
    }

    //post封装
    public static void post(Consumer<String> onNext,Consumer<Throwable> onError, Map<String,String> map,String url){
        ApiServer api = retrofit.create(ApiServer.class);
        Observable<String> observable = api.postTest(url,map);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(onNext,onError);
    }

    //文件上传
    public static void filePost(String url, List<MultipartBody> partsList,Consumer<String> onNext,Consumer<Throwable> onError){
        ApiServer api = retrofit.create(ApiServer.class);
        Observable<String> observable = api.filePost(url,partsList);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(onNext,onError);
    }
}
