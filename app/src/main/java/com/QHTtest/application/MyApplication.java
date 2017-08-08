package com.QHTtest.application;

import android.app.Activity;
import android.app.Application;

import com.QHTtest.model.utils.Constant;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import java.util.Set;

/**
 * Created by 仇海涛 on 2017/7/13.
 * class ：
 * content ：
 */

public class MyApplication extends Application {

    {
        PlatformConfig.setQQZone("1106247411", "lxXvi47PhWUT3kDH");
    }

    private static MyApplication instance;
    private Set<Activity> allActivities;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Constant.init(this);
        Fresco.initialize(this);
        UMShareAPI.get(this);
    }

}
