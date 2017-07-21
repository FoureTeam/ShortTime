package com.QHTtest.view.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.QHTtest.R;
import com.QHTtest.presenter.PostPresenter;

/**
 * Title:登陆界面
 * Thinking:
 * 作者：邹诗惠 on 2017/7/21 19:31
 */

public class LogInActivity extends BaseActivity<PostPresenter> {

    private PostPresenter postPresenter;
    private EditText userPhone;
    private EditText userPassword;
    private TextView login;
    private TextView reg;
    private TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    protected void initListener() {

    }

    @Override
    protected void createPresenter() {
        postPresenter = new PostPresenter();
    }

    @Override
    protected void initView() {
        //初始化控件
        userPhone = (EditText) findViewById(R.id.userPhone_Login);
        userPassword = (EditText) findViewById(R.id.userPassword_Login);
        login = (TextView) findViewById(R.id.login_Login);
        reg = (TextView) findViewById(R.id.regTextView_Login);
        back = (TextView) findViewById(R.id.backTextView_Login);
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
