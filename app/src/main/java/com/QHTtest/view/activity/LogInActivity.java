package com.QHTtest.view.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.QHTtest.R;
import com.QHTtest.presenter.PostPresenter;

/**
 * Title:登陆界面
 * Thinking:
 * 作者：邹诗惠 on 2017/7/21 19:31
 */

public class LogInActivity extends BaseActivity<PostPresenter> implements View.OnClickListener {

    private ImageView leftImageView;
    private TextView titleTextView;
    private ImageView rightImageView;
    private EditText usernameEditText_activityLogin;
    private EditText passwordEditText_activityLogin;
    private LinearLayout contentLinearLayout_activityLogin;
    private TextView loginTextView_activityLogin;
    private TextView regTextView_activityLogin;
    private TextView backTextView_activityLogin;
    private LinearLayout mainLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new PostPresenter();
    }

    @Override
    protected void initView() {

        leftImageView = (ImageView) findViewById(R.id.leftImageView);
        leftImageView.setOnClickListener(this);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        titleTextView.setOnClickListener(this);
        rightImageView = (ImageView) findViewById(R.id.rightImageView);
        rightImageView.setOnClickListener(this);
        usernameEditText_activityLogin = (EditText) findViewById(R.id.usernameEditText_activityLogin);
        usernameEditText_activityLogin.setOnClickListener(this);
        passwordEditText_activityLogin = (EditText) findViewById(R.id.passwordEditText_activityLogin);
        passwordEditText_activityLogin.setOnClickListener(this);
        contentLinearLayout_activityLogin = (LinearLayout) findViewById(R.id.contentLinearLayout_activityLogin);
        contentLinearLayout_activityLogin.setOnClickListener(this);
        loginTextView_activityLogin = (TextView) findViewById(R.id.loginTextView_activityLogin);
        loginTextView_activityLogin.setOnClickListener(this);
        regTextView_activityLogin = (TextView) findViewById(R.id.regTextView_activityLogin);
        regTextView_activityLogin.setOnClickListener(this);
        backTextView_activityLogin = (TextView) findViewById(R.id.backTextView_activityLogin);
        backTextView_activityLogin.setOnClickListener(this);
        mainLinearLayout = (LinearLayout) findViewById(R.id.mainLinearLayout);
        mainLinearLayout.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayout() {
        //设置布局文件
        return R.layout.activity_login;
    }


    private void submit() {
        // validate
        String activityLogin = usernameEditText_activityLogin.getText().toString().trim();
        if (TextUtils.isEmpty(activityLogin)) {
            Toast.makeText(this, "activityLogin不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String activityLoginpws = passwordEditText_activityLogin.getText().toString().trim();
        if (TextUtils.isEmpty(activityLogin)) {
            Toast.makeText(this, "activityLogin不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


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
