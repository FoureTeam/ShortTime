package com.QHTtest.view.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.QHTtest.R;
import com.QHTtest.presenter.HomePresenter;
import com.QHTtest.view.adapter.RecommendFragVpAdapter;
import com.QHTtest.view.fragment.LocalWorkFragment;
import com.QHTtest.view.fragment.RecommendAttentionFrag;
import com.QHTtest.view.fragment.RecommendHotFrag;
import com.QHTtest.view.fragment.UploadedFragment;

import java.util.ArrayList;

/**
 * Title:
 * Thinking:
 * 作者：邹诗惠 on 2017/7/31 11:48
 */

public class MyWorksActivity extends BaseActivity<HomePresenter> implements View.OnClickListener {

    private ViewPager content_myWorks;
    private TabLayout title_myWorks;
    private TextView back;
    private TextView title;
    private TextView nothing;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private RecommendFragVpAdapter adapter;

    @Override
    protected void initListener() {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new HomePresenter();
    }

    @Override
    protected void initView() {
        content_myWorks = (ViewPager) findViewById(R.id.content_myWorks);
        title_myWorks = (TabLayout) findViewById(R.id.title_myWorks);
        back = (TextView) findViewById(R.id.left_my);
        title = (TextView) findViewById(R.id.title_my);
        nothing = (TextView) findViewById(R.id.right_my);
        title.setText("我的作品");
        nothing.setText("");
    }

    @Override
    protected void initData() {
        fragments.add(new LocalWorkFragment());
        fragments.add(new UploadedFragment());
        adapter = new RecommendFragVpAdapter(getSupportFragmentManager());
        adapter.setData(fragments);

        title_myWorks.setTabTextColors(Color.GRAY, Color.BLUE);

        title_myWorks.setSelectedTabIndicatorColor(Color.BLUE);
        title_myWorks.addTab(title_myWorks.newTab().setText("本地作品"));
        title_myWorks.addTab(title_myWorks.newTab().setText("已上传"));
        content_myWorks.setAdapter(adapter);
        content_myWorks.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(title_myWorks));
        title_myWorks.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                content_myWorks.setCurrentItem(position);
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
    public int getLayout() {
        return R.layout.activity_my_works;
    }

    @Override
    public void onClick(View v) {

    }
}
