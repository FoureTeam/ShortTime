package com.QHTtest.view.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.QHTtest.R;
import com.QHTtest.model.bean.LoginBean;
import com.QHTtest.model.utils.Constant;
import com.QHTtest.presenter.LoginPresenter;
import com.QHTtest.view.iview.DataIView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;
import java.util.Map;

/**
 * Title:登陆界面
 * Thinking:
 * 作者：邹诗惠 on 2017/7/21 19:31
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements View.OnClickListener,DataIView<LoginBean> {

    private ImageView login_back;
    private EditText usernameEditText_activityLogin;
    private EditText passwordEditText_activityLogin;
    private TextView loginTextView_activityLogin;
    private TextView regTextView_activityLogin;
    private TextView backTextView_activityLogin;
    private LinearLayout mainLinearLayout;
    private Map<String,String> map = new HashMap<>();
    private String activityLogin;
    private String activityLoginpws;
    private TextView tourist_login;
    private SimpleDraweeView login_log;

    @Override
    protected void initListener() {
        login_back.setOnClickListener(this);

        passwordEditText_activityLogin.setOnClickListener(this);
        usernameEditText_activityLogin.setOnClickListener(this);
        regTextView_activityLogin.setOnClickListener(this);
        backTextView_activityLogin.setOnClickListener(this);
        loginTextView_activityLogin.setOnClickListener(this);
        tourist_login.setOnClickListener(this);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new LoginPresenter();
    }

    @Override
    protected void initView() {

        login_back = (ImageView) findViewById(R.id.login_back);

        usernameEditText_activityLogin = (EditText) findViewById(R.id.usernameEditText_activityLogin);

        passwordEditText_activityLogin = (EditText) findViewById(R.id.passwordEditText_activityLogin);

        loginTextView_activityLogin = (TextView) findViewById(R.id.loginTextView_activityLogin);

        regTextView_activityLogin = (TextView) findViewById(R.id.regTextView_activityLogin);

        backTextView_activityLogin = (TextView) findViewById(R.id.backTextView_activityLogin);

        tourist_login = (TextView) findViewById(R.id.tourist_login);

        login_log = (SimpleDraweeView) findViewById(R.id.login_log);

    }

    @Override
    protected void initData() {
        login_log.setImageResource(R.mipmap.log);
    }

    @Override
    public int getLayout() {
        //设置布局文件
        return R.layout.activity_login;
    }


    private void submit() {
        // validate
        activityLogin = usernameEditText_activityLogin.getText().toString().trim();
        if (TextUtils.isEmpty(activityLogin)) {
            Toast.makeText(this, "activityLogin不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        activityLoginpws = passwordEditText_activityLogin.getText().toString().trim();
        if (TextUtils.isEmpty(activityLogin)) {
            Toast.makeText(this, "activityLogin不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_back:
                finish();
                break;
            case R.id.loginTextView_activityLogin:
                submit();
                map.put("userPassword",activityLoginpws+"");
                map.put("userPhone",activityLogin);
                mPresenter.postLogin(map, LoginBean.class,"http://169.254.1.100:8080/yikezhong/user/addLogin");
                break;
            case R.id.regTextView_activityLogin:
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tourist_login:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void callBackData(LoginBean loginBean) {
        if (loginBean!=null){
            int code = Integer.valueOf(loginBean.getCode());
            if (code==200){
                    Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    Constant.mSharedPreferencesEditor.putString("userId",loginBean.getUser().getUserId()+"");
                    Constant.mSharedPreferencesEditor.putString("userName",loginBean.getUser().getUserName());
                    Constant.mSharedPreferencesEditor.putBoolean("userState",true);
                    Constant.mSharedPreferencesEditor.commit();
                    finish();
            }
        }
    }

    @Override
    public void callBackError(Throwable throwable) {

    }
}
