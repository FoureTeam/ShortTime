package com.QHTtest.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.QHTtest.R;
import com.QHTtest.view.adapter.RecommendFragVpAdapter;

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

    private RecommendFragVpAdapter adapter;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recommentFragVp = (ViewPager) view.findViewById(R.id.recommentfrag_viewpager);
        recommentFragTb = (TabLayout) view.findViewById(R.id.recommentfrag_tablayout);

    }

    @Override
    protected void initData() {

        fragments.add(new RecommendHotFrag());
        fragments.add(new RecommendAttentionFrag());

        adapter = new RecommendFragVpAdapter(getActivity().getSupportFragmentManager());
        adapter.setData(fragments);

        recommentFragTb.setTabTextColors(Color.GRAY,Color.BLUE);
        recommentFragTb.setSelectedTabIndicatorColor(Color.BLUE);
        recommentFragTb.addTab(recommentFragTb.newTab().setText("热门"));
        recommentFragTb.addTab(recommentFragTb.newTab().setText("关注"));
        recommentFragVp.setAdapter(adapter);
        recommentFragVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(recommentFragTb));
        recommentFragTb.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                recommentFragVp.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
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
