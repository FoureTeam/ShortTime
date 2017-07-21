package com.QHTtest.presenter;

import android.content.Context;
import android.widget.ImageView;

import com.QHTtest.R;
import com.QHTtest.view.iview.BaseIView;
import com.bumptech.glide.Glide;

/**
 * Created by 仇海涛 on 2017/7/13.
 * class ：
 * content ：
 */

public class BasePresenter <T extends BaseIView>{
    private T t;
    public void attactView(T t){
        this.t = t;
    }
    public T getView(){
        return t;
    }

    public void detachView() {
        if (t != null) {
            t = null;
        }

    }
    public void setImg(Context context, String imgUri, ImageView img){
        Glide.with(context).load(imgUri).placeholder(R.mipmap.ic_normal_class).into(img);
    }
}
