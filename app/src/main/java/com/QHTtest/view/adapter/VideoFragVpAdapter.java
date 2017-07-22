package com.QHTtest.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 仇海涛 on 2017/7/21.
 * class ：
 * content ：
 */

public class VideoFragVpAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments = new ArrayList<>();


    public VideoFragVpAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setData(ArrayList<Fragment> fragments){
        this.fragments = fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}
