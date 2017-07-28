package com.QHTtest.view.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.QHTtest.R;
import com.QHTtest.model.utils.Constant;
import com.QHTtest.view.activity.LogInActivity;
import com.QHTtest.view.activity.SettingActivity;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 仇海涛 on 2017/7/21.
 * class ：
 * content ：
 */

public class DrawerFrag extends BaseFragment implements View.OnClickListener {

    private TextView attention;
    private TextView collection;
    private TextView searchFriend;
    private TextView alerts;
    private TextView works;
    private TextView setting;
    private CircleImageView circleImageView;
    private boolean userState;
    private TextView userName;
    private TextView signature;
    private TextView setting1;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        //初始化控件
        attention = (TextView) getView().findViewById(R.id.attention_draw);
        collection = (TextView) getView().findViewById(R.id.collection_draw);
        searchFriend = (TextView) getView().findViewById(R.id.searchFriend_draw);
        alerts = (TextView) getView().findViewById(R.id.alerts_draw);
        works = (TextView) getView().findViewById(R.id.works_draw);
        setting = (TextView) getView().findViewById(R.id.setting_draw);
        circleImageView = (CircleImageView) view.findViewById(R.id.circleImageView_draw);
        userName = (TextView) view.findViewById(R.id.userName_draw);
        signature = (TextView) view.findViewById(R.id.signature_draw);
        setting1 = (TextView) view.findViewById(R.id.setting_draw);

        //设置表头
        initRight(attention, R.mipmap.ic_draw_attention);
        initRight(collection, R.mipmap.ic_draw_collection);
        initRight(searchFriend, R.mipmap.ic_draw_search);
        initRight(alerts, R.mipmap.ic_draw_alerts);
        initTop(works, R.mipmap.ic_draw_works);
        initTop(setting1, R.mipmap.ic_draw_setting);
    }
    @Override
    public int getLayout() {
        return R.layout.drawerfrag;
    }
    private void initTop(TextView textView, int ic_drawable) {
        //图片
        Drawable drawable = getResources().getDrawable(ic_drawable);
        //大小
        drawable.setBounds(0, 0, 55, 55);
        //方向
        textView.setCompoundDrawables(null, drawable, null, null);
    }

    private void initRight(TextView textView, int ic_drawable) {
        Drawable drawable = getResources().getDrawable(ic_drawable);
        drawable.setBounds(0, 0, 45, 45);
        textView.setCompoundDrawables(drawable, null, null, null);
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initeListener() {
        circleImageView.setOnClickListener(this);
        setting.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        userState = Constant.mSharedPreferences.getBoolean("userState",false);
        if (userState){
            String userNameStr = Constant.mSharedPreferences.getString("userName","");
            userName.setText(userNameStr);
        } else {
            userName.setText("椰汁奶茶");
        }
        super.onResume();
    }

    @Override
    protected void createPresenter() {

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.circleImageView_draw:
                Intent intent = new Intent(getActivity(), LogInActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_draw:
                Intent settingIntent = new Intent(getActivity(), SettingActivity.class);
                startActivity(settingIntent);
                break;
            default:
                break;
        }
    }
}
