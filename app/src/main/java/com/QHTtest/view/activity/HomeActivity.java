package com.QHTtest.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.QHTtest.R;
import com.QHTtest.folding.FoldingPaneLayout;
import com.QHTtest.presenter.HomePresenter;
import com.QHTtest.view.adapter.HomeRecyLeftAda;
import com.QHTtest.view.fragment.CrossTalkFrag;
import com.QHTtest.view.fragment.DrawerFrag;
import com.QHTtest.view.fragment.RecommendFrag;
import com.QHTtest.view.fragment.VideoFrag;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends BaseActivity<HomePresenter> implements BottomNavigationBar.OnTabSelectedListener, View.OnClickListener {

    private RecyclerView class_frag_recy;
    private Map<String, String> map = new HashMap<>();
    private HomeRecyLeftAda ada;
    private CircleImageView home_toolbar_head_img;
    private TextView home_toolbar_text;
    private ImageView home_toolbar_edit_img;
    private BottomNavigationBar navigationbar;
    private RelativeLayout home_rela;
    private RelativeLayout home_startDrawerLayout;
    private RecommendFrag recommendFrag;
    private CrossTalkFrag crossTalkFrag;
    private VideoFrag videoFrag;
    private ArrayList<Fragment> fragments;
    private Toolbar home_toolbar;
    private FoldingPaneLayout home_drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new HomePresenter();
    }

    @Override
    protected void initView() {

        //初始化控件

        home_toolbar = (Toolbar) findViewById(R.id.layout_toolbar);


        home_toolbar_head_img = (CircleImageView) findViewById(R.id.home_toolbar_head_img);
        home_toolbar_text = (TextView) findViewById(R.id.home_toolbar_text);
        home_toolbar_edit_img = (ImageView) findViewById(R.id.home_toolbar_edit_img);
        navigationbar = (BottomNavigationBar) findViewById(R.id.home_bottombar);
        home_rela = (RelativeLayout) findViewById(R.id.home_startDrawerLayout);
        home_startDrawerLayout = (RelativeLayout) findViewById(R.id.home_startDrawerLayout);
        home_drawer = (FoldingPaneLayout) findViewById(R.id.layout_drawer);
        home_toolbar_head_img.setOnClickListener(this);
        home_toolbar_edit_img.setOnClickListener(this);


    }

    @Override
    protected void initData() {


        //初始化fragment
        recommendFrag = new RecommendFrag();
        crossTalkFrag = new CrossTalkFrag();
        videoFrag = new VideoFrag();

        fragments = new ArrayList<>();
        fragments.add(recommendFrag);
        fragments.add(crossTalkFrag);
        fragments.add(videoFrag);

        home_drawer.setProhibitSideslip(true);

        setSupportActionBar(home_toolbar);

      /*  home_drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        home_drawer.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                home_drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                home_drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
            }
        });*/

        //初始化navigationbar
        initBottomNavigationBar();

        initDrawerFragment();

    }


    /**
     * 初始化侧滑页面
     */
    private void initDrawerFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.home_startDrawerLayout, new DrawerFrag())
                .commitAllowingStateLoss();
    }

    private void initBottomNavigationBar() {
        //设置模式：普通模式
        navigationbar.setMode(BottomNavigationBar.MODE_FIXED);

        //设置背景风格:背景颜色波纹改变
        navigationbar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        //初始化子导航页
        BottomNavigationItem recommendItem = new BottomNavigationItem(R.mipmap.ic_recommend_r, "推荐");
        recommendItem.setInActiveColor(R.mipmap.ic_recommend);
        BottomNavigationItem crossTalkItem = new BottomNavigationItem(R.mipmap.ic_crosstalk_c, "段子");
        crossTalkItem.setInactiveIconResource(R.mipmap.ic_crosstalk);
        BottomNavigationItem videoItem = new BottomNavigationItem(R.mipmap.ic_video_v, "视频");
        videoItem.setInactiveIconResource(R.mipmap.ic_video);

        //添加子导航页
        navigationbar.addItem(recommendItem);
        navigationbar.addItem(crossTalkItem);
        navigationbar.addItem(videoItem);

        //设置默认选中条目
        navigationbar.setFirstSelectedPosition(0);

        //未活动图标颜色
        navigationbar.setInActiveColor(R.color.dimgrey);

        //活动时图标颜色
        navigationbar.setActiveColor(R.color.appBlue);

        //初始化
        navigationbar.initialise();

        home_toolbar_text.setText("推荐");

        getSupportFragmentManager().beginTransaction()
                .add(R.id.home_rl_parentview, recommendFrag)
                .add(R.id.home_rl_parentview, crossTalkFrag)
                .add(R.id.home_rl_parentview, videoFrag)
                .hide(fragments.get(1))
                .hide(fragments.get(2))
                .commitAllowingStateLoss();
        navigationbar.setTabSelectedListener(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    int tag = 0;

    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                home_toolbar_text.setText("推荐");

                break;
            case 1:
                home_toolbar_text.setText("段子");

                break;
            case 2:
                home_toolbar_text.setText("视频");

                break;
        }

        if (tag != position) {
            getSupportFragmentManager().beginTransaction().show(fragments.get(position)).hide(fragments.get(tag)).commitAllowingStateLoss();
            tag = position;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_toolbar_head_img:
                if (home_drawer.isOpen()) {
                    home_drawer.closePane();
                } else {
                    home_drawer.openPane();
                }
                break;
            case R.id.home_toolbar_edit_img:
                //跳转页面+Activity2.5跳转动画
                Intent intent = new Intent(HomeActivity.this, UploadVideoActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_right);
                break;

            default:
                break;
        }
    }
}
