package com.QHTtest.presenter;

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

public class PostPresenter extends BasePresenter<DataIView> {
    public <T> void getPostData(Map<String, String> map, final Class<T> cla, String url) {
        HttpUtils.post(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
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
