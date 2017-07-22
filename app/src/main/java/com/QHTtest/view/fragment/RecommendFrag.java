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


    private ViewPager recommendFragVp;
    private TabLayout recommendFragTb;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    private RecommendFragVpAdapter adapter;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recommendFragVp = (ViewPager) view.findViewById(R.id.recommentfrag_viewpager);
        recommendFragTb = (TabLayout) view.findViewById(R.id.recommentfrag_tablayout);

    }

    @Override
    protected void initData() {

        fragments.add(new RecommendHotFrag());
        fragments.add(new RecommendAttentionFrag());

        adapter = new RecommendFragVpAdapter(getActivity().getSupportFragmentManager());
        adapter.setData(fragments);

        recommendFragTb.setTabTextColors(Color.GRAY,Color.BLUE);

        recommendFragTb.setSelectedTabIndicatorColor(Color.BLUE);
        recommendFragTb.addTab(recommendFragTb.newTab().setText("热门"));
        recommendFragTb.addTab(recommendFragTb.newTab().setText("关注"));
        recommendFragVp.setAdapter(adapter);
        recommendFragVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(recommendFragTb));
        recommendFragTb.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                recommendFragVp.setCurrentItem(position);
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
