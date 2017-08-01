package com.QHTtest.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.QHTtest.R;
import com.QHTtest.model.bean.RegisterBean;
import com.QHTtest.presenter.RegisterPresenter;
import com.QHTtest.view.iview.DataIView;

import java.util.HashMap;
import java.util.Map;

/**
 * Title:
 * Thinking:
 * 作者：邹诗惠 on 2017/7/21 19:31
 */

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements View.OnClickListener,DataIView<RegisterBean> {

    private EditText userName_Reg;
    private EditText userPassword_Reg;

    private EditText userPhone_Reg;
    private EditText userSex_Reg;
    private LinearLayout contentLinearLayout_activityReg;
    private TextView regTextView_Reg;


    private Map<String,String> map = new HashMap<>();
    private String userNameReg;
    private String userPasswordReg;
    private String userPhoneReg;
    private String userSexReg;
    private ImageView register_back;
    private TextView reg_tourist_login;
    private TextView regTextView_activityLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initListener() {

        userName_Reg.setOnClickListener(this);

        userPassword_Reg.setOnClickListener(this);

        userPhone_Reg.setOnClickListener(this);

        userSex_Reg.setOnClickListener(this);

        contentLinearLayout_activityReg.setOnClickListener(this);

        regTextView_Reg.setOnClickListener(this);

        register_back.setOnClickListener(this);

        reg_tourist_login.setOnClickListener(this);

        regTextView_activityLogin.setOnClickListener(this);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new RegisterPresenter();
    }

    @Override
    protected void initView() {

        userName_Reg = (EditText) findViewById(R.id.userName_Reg);

        userPassword_Reg = (EditText) findViewById(R.id.userPassword_Reg);

        userPhone_Reg = (EditText) findViewById(R.id.userPhone_Reg);

        userSex_Reg = (EditText) findViewById(R.id.userSex_Reg);

        contentLinearLayout_activityReg = (LinearLayout) findViewById(R.id.contentLinearLayout_activityReg);

        regTextView_Reg = (TextView) findViewById(R.id.regTextView_Reg);

        register_back = (ImageView) findViewById(R.id.register_back);

        reg_tourist_login = (TextView) findViewById(R.id.reg_tourist_login);

        regTextView_activityLogin = (TextView) findViewById(R.id.regTextView_activityLogin);
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_register;
    }

    private void submit() {
        // validate


        userNameReg = userName_Reg.getText().toString().trim();
        if (TextUtils.isEmpty(userNameReg)) {
            Toast.makeText(this, "Reg不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        userPasswordReg = userPassword_Reg.getText().toString().trim();
        if (TextUtils.isEmpty(userPasswordReg)) {
            Toast.makeText(this, "Reg不能为空", Toast.LENGTH_SHORT).show();
            return;
        }


        userPhoneReg = userPhone_Reg.getText().toString().trim();
        if (TextUtils.isEmpty(userPhoneReg)) {
            Toast.makeText(this, "Reg不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        userSexReg = userSex_Reg.getText().toString().trim();
        if (TextUtils.isEmpty(userSexReg)) {
            Toast.makeText(this, "Reg不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regTextView_Reg:
                submit() ;
                map.put("userName",userNameReg);
                map.put("userPassword",userPasswordReg);
                map.put("userPhone",userPhoneReg);
                map.put("userSex",userSexReg);

                mPresenter.postRegister(map, RegisterBean.class,"http://169.254.1.100/yikezhong/user/addUser");
                break;
            case R.id.register_back:
                finish();
                break;
            case R.id.reg_tourist_login:
                finish();
                break;
            case R.id.regTextView_activityLogin:
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void callBackData(RegisterBean registerBean) {
        if (registerBean!=null){
            if (registerBean.getCode()==200){
                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    public void callBackError(Throwable throwable) {

    }
}
