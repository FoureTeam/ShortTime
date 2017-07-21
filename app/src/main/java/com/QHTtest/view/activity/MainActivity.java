package com.QHTtest.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.QHTtest.R;
import com.QHTtest.model.bean.HomeBean;
import com.QHTtest.presenter.HomePresenter;
import com.QHTtest.view.adapter.HomeRecyLeftAda;
import com.QHTtest.view.iview.DataIView;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity<HomePresenter> implements DataIView<HomeBean> {

    private RecyclerView class_frag_recy;
    private Map<String, String> map = new HashMap<>();
    private HomeRecyLeftAda ada;
    private CircleImageView home_toolbar_head_img;
    private TextView home_toolbar_text;
    private ImageView home_toolbar_edit_img;
    private BottomNavigationBar navigationbar;
    private RelativeLayout home_rela;
    private RelativeLayout home_startDrawerLayout;

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


        home_toolbar_head_img = (CircleImageView) findViewById(R.id.home_toolbar_head_img);
        home_toolbar_text = (TextView) findViewById(R.id.home_toolbar_text);
        home_toolbar_edit_img = (ImageView) findViewById(R.id.home_toolbar_edit_img);
        navigationbar = (BottomNavigationBar) findViewById(R.id.navigationbar);
        home_rela = (RelativeLayout) findViewById(R.id.home_rela);
        home_startDrawerLayout = (RelativeLayout) findViewById(R.id.home_startDrawerLayout);
    }

    @Override
    protected void initData() {
        //设置模式：普通模式
        navigationbar.setMode(BottomNavigationBar.MODE_FIXED);

        //设置背景风格:背景颜色波纹改变
        navigationbar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        //初始化子导航页
        BottomNavigationItem recommendItem = new BottomNavigationItem(R.mipmap.chat_press, "推荐");
        BottomNavigationItem crossTalkItem = new BottomNavigationItem(R.mipmap.discovery_press, "段子");
        BottomNavigationItem videoItem = new BottomNavigationItem(R.mipmap.me_press, "视频");

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



    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void callBackData(HomeBean homeBean) {

    }

    @Override
    public void callBackError(Throwable throwable) {

    }
}
