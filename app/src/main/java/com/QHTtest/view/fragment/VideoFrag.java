package com.QHTtest.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.QHTtest.R;
import com.QHTtest.view.adapter.VideoFragVpAdapter;

import java.util.ArrayList;

/**
 * Created by 仇海涛 on 2017/7/21.
 * class ：
 * content ：
 */

public class VideoFrag extends BaseFragment {


    private ViewPager videoFragVp;
    private TabLayout videoFragTb;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private VideoFragVpAdapter adapter;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        videoFragVp = (ViewPager) view.findViewById(R.id.videofrag_viewpager);
        videoFragTb = (TabLayout) view.findViewById(R.id.videofrag_tablayout);

    }

    @Override
    protected void initData() {

        fragments.add(new VideoHotFrag());
        fragments.add(new VideoNearbyFrag());

        adapter = new VideoFragVpAdapter(getActivity().getSupportFragmentManager());
        adapter.setData(fragments);

        videoFragTb.setTabTextColors(Color.GRAY,Color.BLUE);
        videoFragTb.setSelectedTabIndicatorColor(Color.BLUE);

        videoFragTb.addTab(videoFragTb.newTab().setText("热门"));
        videoFragTb.addTab(videoFragTb.newTab().setText("附近"));

        videoFragVp.setAdapter(adapter);
        videoFragVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(videoFragTb));
        videoFragTb.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                videoFragVp.setCurrentItem(position);
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
        return R.layout.videofrag;
    }


}
