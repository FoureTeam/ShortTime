package com.QHTtest.view.constom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.QHTtest.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Title:
 * Thinking:
 * 作者：邹诗惠 on 2017/7/28 17:13
 */

public class AttentionView extends RelativeLayout {

    private CircleImageView userImag;
    private TextView userName;
    private TextView introduce;
    private TextView data;
    private ImageView img;

    //在代码调用的时候使用
    public AttentionView(Context context) {
        super(context);
        init();
    }

    //在布局文件中使用的时候调用，比两个参数的多个样式文件
    public AttentionView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    //在布局文件中使用的时候调用
    public AttentionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 添加布局文件
     */
    private void init() {
        //添加布局文件的操作
        View view = View.inflate(getContext(), R.layout.attention_combination, this);//先有孩子，再去找爹，喜当爹
        //初始化控件
        userImag = (CircleImageView) view.findViewById(R.id.userImag_atte_recy);
        userName = (TextView) view.findViewById(R.id.userName_atte_recy);
        introduce = (TextView) view.findViewById(R.id.introduce_atte_recy);
        data = (TextView) view.findViewById(R.id.date_atte_recy);
        img = (ImageView) view.findViewById(R.id.image_atte_recy);
    }

    /**
     * 设置标题
     *
     */
    public void setUserImag(Drawable drawable) {
        userImag.setImageDrawable(drawable);
    }
    /**
     * 设置用户名
     *
     */
    public void setUserName(String des) {
        userName.setText(des);
    }
    /**
     * 设置详情
     *
     */
    public void setIntroduce(String title) {
        introduce.setText(title);
    }

    /**
     * 设置日期
     *
     */
    public void setData(String des) {
        data.setText(des);
    }


}
