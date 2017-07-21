package com.QHTtest.view.iview;

/**
 * Created by 仇海涛 on 2017/7/13.
 * class ：
 * content ：
 */

public interface DataIView<T> extends BaseIView {
    void callBackData(T t);
    void callBackError(Throwable throwable);
}
