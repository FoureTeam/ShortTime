package com.QHTtest.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.QHTtest.presenter.BasePresenter;

/**
 * Created by 仇海涛 on 2017/7/21.
 * class ：
 * content ：
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {
    private T mPresenter;

    protected Activity mActivity;

    /**
     * 获得全局的，防止使用getActivity()为空
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(mActivity).inflate(getLayout(),container,false);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        createPresenter();

        initView(getView(),savedInstanceState);

        initeListener();

        initData();
    }

    /**
     * 该抽象方法就是 初始化view
     */
    protected abstract void initView(View view, Bundle savedInstanceState);

    /**
     * 执行数据的加载
     */
    protected abstract void initData();

    /**
     * 控件的监听
     */
    protected abstract void initeListener();

    /**
     * 关联presenter
     */
    protected abstract void createPresenter();

    /**
     * 该抽象方法就是 onCreateView中需要的layoutID
     * @return
     */
    public abstract int getLayout() ;


}
