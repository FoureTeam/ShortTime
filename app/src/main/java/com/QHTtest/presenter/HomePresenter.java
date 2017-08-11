package com.QHTtest.presenter;

import android.util.Log;

import com.QHTtest.model.utils.Constant;
import com.QHTtest.model.utils.HttpUtils;
import com.QHTtest.view.iview.DataIView;

import java.util.Map;

import io.reactivex.functions.Consumer;

/**
 * Created by 仇海涛 on 2017/7/13.
 * class ：
 * content ：
 */

public class HomePresenter extends BasePresenter<DataIView> {

    public <T> void getData(Map<String, String> map, final Class<T> cla, String url) {
        HttpUtils.get(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e("memeda", s.toString());
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
