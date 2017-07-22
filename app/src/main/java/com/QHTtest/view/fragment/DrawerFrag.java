package com.QHTtest.view.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.QHTtest.R;

/**
 * Created by 仇海涛 on 2017/7/21.
 * class ：
 * content ：
 */

public class DrawerFrag extends BaseFragment {

    private TextView attention;
    private TextView collection;
    private TextView searchFriend;
    private TextView alerts;
    private TextView works;
    private TextView setting;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        //初始化控件
        attention = (TextView) getView().findViewById(R.id.attention_draw);
        collection = (TextView) getView().findViewById(R.id.collection_draw);
        searchFriend = (TextView) getView().findViewById(R.id.searchFriend_draw);
        alerts = (TextView) getView().findViewById(R.id.alerts_draw);
        works = (TextView) getView().findViewById(R.id.works_draw);
        setting = (TextView) getView().findViewById(R.id.setting_draw);
        //设置表头
        initRight(attention, R.mipmap.ic_draw_attention);
        initRight(collection, R.mipmap.ic_draw_collection);
        initRight(searchFriend, R.mipmap.ic_draw_search);
        initRight(alerts, R.mipmap.ic_draw_alerts);
        initTop(works, R.mipmap.ic_draw_works);
        initTop(setting, R.mipmap.ic_draw_setting);
    }

    private void initTop(TextView textView, int ic_drawable) {
        //图片
        Drawable drawable = getResources().getDrawable(ic_drawable);
        //大小
        drawable.setBounds(0, 0, 80, 80);
        //方向
        textView.setCompoundDrawables(null, drawable, null, null);
    }

    private void initRight(TextView textView, int ic_drawable) {
        Drawable drawable = getResources().getDrawable(ic_drawable);
        drawable.setBounds(0, 0, 50, 50);
        textView.setCompoundDrawables(drawable, null, null, null);
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initeListener() {

    }

    @Override
    protected void createPresenter() {

    }

    @Override
    public int getLayout() {
        return R.layout.drawerfrag;
    }


}
