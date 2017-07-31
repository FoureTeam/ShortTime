package com.QHTtest.view.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.QHTtest.R;
import com.QHTtest.presenter.PostPresenter;
import com.QHTtest.view.adapter.AttentionRecyleAdapter;
import com.QHTtest.view.constom.AttentionView;
import com.QHTtest.view.constom.DividerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:
 * Thinking:
 * 作者：邹诗惠 on 2017/7/28 17:29
 */

public class AttentionActivity extends BaseActivity<PostPresenter> {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipe;
    private AttentionRecyleAdapter adapter;
    private List<String> s;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initListener() {
        initPullRefresh();

    }

    @Override
    protected void createPresenter() {
        mPresenter = new PostPresenter();
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_atte);
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe_atte);
        recyclerView.addItemDecoration(new DividerView(AttentionActivity.this));
        swipe.setColorSchemeColors(Color.BLUE, Color.BLACK,
                Color.RED, Color.YELLOW);
        initHttpT();
        initHttp();

    }

    private void initHttpT() {
        //创建适配器
        adapter = new AttentionRecyleAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void initHttp() {
        s = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            s.add("加油吧!包子");
        }
        adapter.setData(s);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_attention;
    }

    //上拉刷新
    private void initPullRefresh() {
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        List<String> data2 = new ArrayList<String>();
                        data2.add("花花");
                        adapter.AddHeaderItem(data2);
                        //刷新完成
                        swipe.setRefreshing(false);
                    }

                }, 3000);
            }
        });
    }


}
