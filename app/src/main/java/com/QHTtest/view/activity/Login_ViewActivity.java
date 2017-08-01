package com.QHTtest.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.QHTtest.R;
import com.QHTtest.presenter.HomePresenter;

/**
 * Created by 仇海涛 on 2017/7/31.
 * class ：
 * content ：
 */

public class Login_ViewActivity extends BaseActivity implements View.OnClickListener {

    private ImageView login_view_back;
    private LinearLayout weixinlogin;
    private LinearLayout qQlogin;
    private TextView morelogin;

    @Override
    protected void initListener() {
        login_view_back.setOnClickListener(this);
        weixinlogin.setOnClickListener(this);
        morelogin.setOnClickListener(this);
        qQlogin.setOnClickListener(this);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new HomePresenter();
    }

    @Override
    protected void initView() {
        login_view_back = (ImageView) findViewById(R.id.login_view_back);
        weixinlogin = (LinearLayout) findViewById(R.id.login_linearLayout_01);
        qQlogin = (LinearLayout) findViewById(R.id.login_linearLayout_02);
        morelogin = (TextView) findViewById(R.id.morelogin );
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_login_view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_view_back:
                finish();
                break;
            case R.id.login_linearLayout_01:

                break;
            case R.id.login_linearLayout_02:

                break;
            case R.id.morelogin:
                Intent moreIntent = new Intent(Login_ViewActivity.this,LoginActivity.class);
                startActivity(moreIntent);
                finish();
                break;
            default:
                break;
        }
    }
}
