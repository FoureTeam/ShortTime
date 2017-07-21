package com.QHTtest.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.QHTtest.R;

import java.util.ArrayList;


/**
 * Created by 仇海涛 on 2017/7/21.
 * class ：
 * content ：
 */

public class RecommendFrag extends BaseFragment {


    private ViewPager recommentFragVp;
    private TabLayout recommentFragTb;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> strings = new ArrayList<>();

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recommentFragVp = (ViewPager) view.findViewById(R.id.recommentfrag_viewpager);
        recommentFragTb = (TabLayout) view.findViewById(R.id.recommentfrag_tablayout);

    }

    @Override
    protected void initData() {

        strings.add("热门");
        strings.add("关注");

        fragments.add(new RecommendHotFrag());
        fragments.add(new RecommendAttentionFrag());


    }

    @Override
    protected void initeListener() {

    }

    @Override
    protected void createPresenter() {

    }

    @Override
    public int getLayout() {
        return R.layout.recommendfrag;
    }


}
