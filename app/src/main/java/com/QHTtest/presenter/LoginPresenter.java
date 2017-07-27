package com.QHTtest.presenter;

import android.util.Log;

import com.QHTtest.model.utils.Constant;
import com.QHTtest.model.utils.HttpUtils;
import com.QHTtest.view.iview.DataIView;

import java.util.Map;

import io.reactivex.functions.Consumer;

/**
 * Title:
 * Thinking:
 * 作者：邹诗惠 on 2017/7/21 19:32
 */

public class LoginPresenter extends BasePresenter<DataIView> {
    public <T> void postLogin(Map<String, String> map, final Class<T> cla, String url) {
        HttpUtils.post(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d("memeda", "login: "+s);
                T t = Constant.GsonToBean(s, cla);
                getView().callBackData(t);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.d("memeda", "login: "+throwable.toString());
            }
        }, map, url);
    }
}
