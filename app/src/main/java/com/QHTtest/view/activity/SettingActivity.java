package com.QHTtest.view.activity;

import android.view.View;
import android.widget.Button;

import com.QHTtest.R;
import com.QHTtest.model.utils.Constant;
import com.QHTtest.presenter.PostPresenter;

/**
 * Created by 仇海涛 on 2017/7/27.
 * class ：
 * content ：
 */

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private Button signOut;

    @Override
    protected void initListener() {
        signOut.setOnClickListener(this);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new PostPresenter();
    }

    @Override
    protected void initView() {
        signOut = (Button) findViewById(R.id.signOut);
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_set;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signOut:
                Constant.mSharedPreferencesEditor.clear();
                Constant.mSharedPreferencesEditor.commit();
                finish();
                break;

            default:
                break;
        }
    }
}
