package com.QHTtest.presenter;

import android.util.Log;

import com.QHTtest.model.utils.HttpUtils;
import com.QHTtest.view.iview.DataIView;

import java.util.List;

import io.reactivex.functions.Consumer;
import okhttp3.MultipartBody;

/**
 * Created by 仇海涛 on 2017/7/24.
 * class ：
 * content ：
 */

public class UpLoadPresenter extends BasePresenter<DataIView> {
    public <T>void filePost(String url, List<MultipartBody.Part> partsList, final Class<T> cla){
        HttpUtils.filePost(url, partsList, new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e("11111", s );
//                T t = Constant.GsonToBean(s, cla);
//                getView().callBackData(t);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e("11111", throwable.toString() );
            }
        });
    }
}
