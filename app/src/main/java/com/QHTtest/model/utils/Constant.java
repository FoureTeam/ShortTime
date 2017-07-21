package com.QHTtest.model.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by 仇海涛 on 2017/7/13.
 * class ：
 * content ：
 */

public class Constant {
    public static String SYSTEM_SHARE_NAME="config";
    public static final String LINK_MAIN = "http://169.254.220.2/mobile/";
    public static SharedPreferences mSharedPreferences;
    public static SharedPreferences.Editor mSharedPreferencesEditor;
    public static Gson gson;
    //初始化
    public static void init(Context context) {
        mSharedPreferences = context.getSharedPreferences(Constant.SYSTEM_SHARE_NAME, Activity.MODE_PRIVATE);
        mSharedPreferencesEditor = mSharedPreferences.edit();
        gson=new Gson();
    }
    //gson封装
    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }
}
