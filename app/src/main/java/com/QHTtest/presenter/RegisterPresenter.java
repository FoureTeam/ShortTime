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

public class RegisterPresenter extends BasePresenter<DataIView> {
    public <T> void postRegister(Map<String, String> map, final Class<T> cla, String url) {
        HttpUtils.post(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d("memeda", "register: "+s);
                T t = Constant.GsonToBean(s, cla);
                getView().callBackData(t);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        }, map, url);
    }
}
