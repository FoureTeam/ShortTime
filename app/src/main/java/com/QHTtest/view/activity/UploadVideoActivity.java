package com.QHTtest.view.activity;

import android.os.Bundle;

import com.QHTtest.R;
import com.QHTtest.presenter.UpLoadPresenter;

/**
 * Title:视频上传
 * Thinking:
 * 作者：邹诗惠 on 2017/7/27 09:38
 */

public class UploadVideoActivity extends BaseActivity<UpLoadPresenter> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new UpLoadPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_upload_video;
    }
}
