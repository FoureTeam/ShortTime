package com.QHTtest.view.activity;

import com.QHTtest.presenter.PostPresenter;

/**
 * Created by 仇海涛 on 2017/7/27.
 * class ：
 * content ：
 */

public class SettingActivity extends BaseActivity {
    @Override
    protected void initListener() {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new PostPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayout() {
        return 0;
    }
}
