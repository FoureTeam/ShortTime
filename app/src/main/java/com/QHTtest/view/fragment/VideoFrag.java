package com.QHTtest.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;

import com.QHTtest.R;

/**
 * Created by 仇海涛 on 2017/7/21.
 * class ：
 * content ：
 */

public class VideoFrag extends BaseFragment {


    private TabLayout recommentFragVp;
    private TabLayout recommentFragTb;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recommentFragVp = view.findViewById(R.id.videofrag_viewpager);
        recommentFragTb = view.findViewById(R.id.videofrag_tablayout);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initeListener() {

    }

    @Override
    protected void createPresenter() {

    }

    @Override
    public int getLayout() {
        return R.layout.videofrag;
    }


}
