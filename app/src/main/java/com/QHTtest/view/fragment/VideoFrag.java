package com.QHTtest.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.QHTtest.R;

/**
 * Created by 仇海涛 on 2017/7/21.
 * class ：
 * content ：
 */

public class VideoFrag extends BaseFragment {


    private ViewPager videoFragVp;
    private TabLayout videoFragTb;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
//        videoFragVp = view.findViewById(R.id.videofrag_viewpager);
//        videoFragTb = view.findViewById(R.id.videofrag_tablayout);
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
