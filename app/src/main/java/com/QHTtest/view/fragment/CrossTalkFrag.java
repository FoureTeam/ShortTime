package com.QHTtest.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.QHTtest.R;
import com.QHTtest.model.bean.CrossTalkFragBean;
import com.QHTtest.presenter.HomePresenter;
import com.QHTtest.view.adapter.CrossFragAdapter;
import com.QHTtest.view.iview.DataIView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 仇海涛 on 2017/7/21.
 * class ：
 * content ：
 */

public class CrossTalkFrag extends BaseFragment<HomePresenter> implements DataIView<CrossTalkFragBean> {


    private HomePresenter presenter;
    private Map<String,String> map = new HashMap();
    private CrossFragAdapter adapter;
    private RecyclerView rlv;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        rlv = (RecyclerView) view.findViewById(R.id.rlv);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rlv.setLayoutManager(manager);
    }

    @Override
    protected void initData() {

        adapter = new CrossFragAdapter(getActivity());
        rlv.setAdapter(adapter);
        presenter.getData(map,CrossTalkFragBean.class,"character/select_character");
        rlv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void initeListener() {

    }

    @Override
    protected void createPresenter() {
        presenter = new HomePresenter();
        presenter.attactView(this);

    }

    @Override
    public int getLayout() {
        return R.layout.crosstalkfrag;
    }


    @Override
    public void callBackData(CrossTalkFragBean crossTalkFragBean) {
        Log.d("callBackData", "callBackData: "+crossTalkFragBean.getCode());
        if (crossTalkFragBean!=null){
            List<CrossTalkFragBean.CharacterBean> character = crossTalkFragBean.getCharacter();
            Log.d("callBackData", "callBackData: "+character.size());
            adapter.setData(character);
        }
    }

    @Override
    public void callBackError(Throwable throwable) {

    }
}
