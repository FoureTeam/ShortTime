package com.QHTtest.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.QHTtest.R;
import com.QHTtest.model.utils.Constant;
import com.QHTtest.presenter.HomePresenter;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

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
    private UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调，可以用来处理等待框，或相关的文字提示
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Constant.mSharedPreferencesEditor.putString("userName",data.get("name"));
            Constant.mSharedPreferencesEditor.putBoolean("userState",true);
            Constant.mSharedPreferencesEditor.putString("uri",data.get("profile_image_url"));
            Constant.mSharedPreferencesEditor.commit();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {

        }
    };
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
        weixinlogin = (LinearLayout) findViewById(R.id.login_linearLayout_weixin);
        qQlogin = (LinearLayout) findViewById(R.id.login_linearLayout_qq);
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
            case R.id.login_linearLayout_weixin:

                break;
            case R.id.login_linearLayout_qq:
                UMShareAPI umShareAPI = UMShareAPI.get(this);
                UMShareConfig config = new UMShareConfig();
                config.isNeedAuthOnGetUserInfo(true);
                umShareAPI.setShareConfig(config);
                umShareAPI.getPlatformInfo(Login_ViewActivity.this,SHARE_MEDIA.QQ, authListener);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
