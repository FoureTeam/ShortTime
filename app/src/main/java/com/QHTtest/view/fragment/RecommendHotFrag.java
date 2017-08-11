package com.QHTtest.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.QHTtest.R;
import com.QHTtest.model.bean.RecommendHotBean;
import com.QHTtest.presenter.HomePresenter;
import com.QHTtest.view.adapter.RecommendHotAdapter;
import com.QHTtest.view.iview.DataIView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 仇海涛 on 2017/7/21.
 * class ：
 * content ：
 */

public class RecommendHotFrag extends BaseFragment<HomePresenter> implements DataIView<RecommendHotBean>{


    private HomePresenter presenter;
    private Map<String,String> map = new HashMap<>();
    private RecyclerView recycler;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recycler = (RecyclerView) mActivity.findViewById(R.id.recommendhotfrag_recy);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initeListener() {

    }

    @Override
    protected void createPresenter() {
        presenter = new HomePresenter();
        presenter.attactView(this);
        presenter.getData(map, RecommendHotBean.class,"user/findHot");
    }

    @Override
    public int getLayout() {
        return R.layout.recommendhotfrag;
    }


    @Override
    public void callBackData(RecommendHotBean recommendHotBean) {
        List<RecommendHotBean.ResourceBean> resource = recommendHotBean.getResource();
        RecommendHotAdapter adapter = new RecommendHotAdapter(mActivity, resource);
        GridLayoutManager   gridLayoutManager = new GridLayoutManager(mActivity,1);
        recycler.setLayoutManager(gridLayoutManager);
        recycler.setAdapter(adapter);

    }

    @Override
    public void callBackError(Throwable throwable) {

    }
}
