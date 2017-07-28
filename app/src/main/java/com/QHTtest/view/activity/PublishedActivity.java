package com.QHTtest.view.activity;

import android.view.View;
import android.widget.ImageView;

import com.QHTtest.R;
import com.QHTtest.presenter.HomePresenter;

/**
 * Title:创作界面
 * Thinking:
 * 作者：邹诗惠 on 2017/7/27 09:16
 */

public class PublishedActivity extends BaseActivity implements View.OnClickListener {


    private ImageView leftImageView;

    @Override
    protected void initListener() {
        leftImageView.setOnClickListener(this);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new HomePresenter();
    }

    @Override
    protected void initView() {
        leftImageView = (ImageView) findViewById(R.id.leftImageView);
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_published;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.leftImageView:
                finish();
                break;

            default:
                break;
        }
    }
}
