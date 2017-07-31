package com.QHTtest.view.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

public class AttentionActivity extends BaseActivity<PostPresenter> implements View.OnClickListener {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipe;
    private AttentionRecyleAdapter adapter;
    private List<String> s;
    private TextView back;
    private TextView hot;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initListener() {
        initPullRefresh();
        back.setOnClickListener(this);
        hot.setOnClickListener(this);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new PostPresenter();
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_atte);
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe_atte);
        back = (TextView) findViewById(R.id.left_my);
        hot = (TextView) findViewById(R.id.right_my);
        hot.setText("热门关注");
    }

    @Override
    protected void initData() {
        initHttpT();
        initHttp();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_attention;
    }

    private void initHttpT() {
        //添加自定义分割线
        recyclerView.addItemDecoration(new DividerView(AttentionActivity.this));
        //设置下拉刷新颜色
        swipe.setColorSchemeColors(Color.BLUE, Color.BLACK,
                Color.RED, Color.YELLOW);
        //创建适配器
        adapter = new AttentionRecyleAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    //添加虚拟数据
    private void initHttp() {
        s = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            s.add("加油吧!包子");
        }
        adapter.setData(s);
        recyclerView.setAdapter(adapter);

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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_my: {
                Toast.makeText(AttentionActivity.this,"返回",Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.right_my: {
                Toast.makeText(AttentionActivity.this,"热门关注",Toast.LENGTH_SHORT).show();
            }
            break;

        }
    }
}
