package com.QHTtest.view.activity;

import android.os.Bundle;

import com.QHTtest.R;
import com.QHTtest.presenter.PostPresenter;

/**
 * Title:登陆界面
 * Thinking:
 * 作者：邹诗惠 on 2017/7/21 19:31
 */

public class LogInActivity extends BaseActivity<PostPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    protected void initListener() {

    }

    @Override
    protected void createPresenter() {
        
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayout() {
        //设置布局文件
        return R.layout.activity_login;
    }
}
