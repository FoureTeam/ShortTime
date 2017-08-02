package com.QHTtest.application;

import android.app.Activity;
import android.app.Application;

import com.QHTtest.model.utils.Constant;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.Set;

/**
 * Created by 仇海涛 on 2017/7/13.
 * class ：
 * content ：
 */

public class MyApplication extends Application {

    private static MyApplication instance;
    private Set<Activity> allActivities;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Constant.init(this);
        Fresco.initialize(this);

    }

}
