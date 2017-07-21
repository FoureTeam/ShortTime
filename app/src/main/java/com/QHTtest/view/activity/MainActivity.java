package com.QHTtest.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.QHTtest.R;
import com.QHTtest.model.bean.HomeBean;
import com.QHTtest.presenter.HomePresenter;
import com.QHTtest.view.adapter.HomeRecyLeftAda;
import com.QHTtest.view.iview.DataIView;
import com.QHTtest.view.iview.Recy_OnClick;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity<HomePresenter> implements DataIView<HomeBean> {

    private RecyclerView class_frag_recy;
    private Map<String,String> map = new HashMap<>();
    private HomeRecyLeftAda ada;

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

        class_frag_recy = (RecyclerView) findViewById(R.id.class_frag_recy);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        class_frag_recy.setLayoutManager(manager);
    }

    @Override
    protected void initData() {
        map.put("act","goods_class");
        ada = new HomeRecyLeftAda(this);

        class_frag_recy.setAdapter(ada);
        mPresenter.getHomeRecyData(map,HomeBean.class,"index.php");
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void callBackData(HomeBean homeBean) {
        ada.setData(homeBean.getDatas().getClass_list(),mPresenter);
        ada.setOnClick(new Recy_OnClick() {
            @Override
            public void onClick(View view, int position, String gc_id) {
                showShort(position+"");
            }
        });
    }

    @Override
    public void callBackError(Throwable throwable) {

    }
}
