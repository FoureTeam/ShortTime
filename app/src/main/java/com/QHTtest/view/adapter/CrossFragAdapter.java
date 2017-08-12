package com.QHTtest.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.QHTtest.R;
import com.QHTtest.model.bean.CrossTalkFragBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 仇海涛 on 2017/8/8.
 * class ：
 * content ：
 */

public class CrossFragAdapter extends Adapter<CrossFragAdapter.MyViewHolder> {
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(context,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(context,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(context,"取消了",Toast.LENGTH_LONG).show();

        }
    };
    private Context context;

    public CrossFragAdapter(Context context) {
        this.context = context;
    }

    List<CrossTalkFragBean.CharacterBean> data = new ArrayList<>();
    public void setData( List<CrossTalkFragBean.CharacterBean> character){
        Log.d("crossfragada", "setData: "+character.size());
        if (character!=null){
            this.data = character;
            Log.d("crossfragada", "setData: "+data.size());
            notifyDataSetChanged();
        }

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_recy_crosstalkfrag,null);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.item_cross_text.setText(data.get(position).getCharacter_content());
        holder.user_name.setText(data.get(position).getUser().getUserSignature());
        holder.user_time.setText(data.get(position).getCharacter_uptime());
        holder.user_head.setImageURI("http://v1.qzone.cc/avatar/201409/24/19/58/5422b1ff86ed0232.jpg%21200x200.jpg");
        DraweeController mDraweeController = Fresco.newDraweeControllerBuilder()
                .setAutoPlayAnimations(true)
                // .setUri(Uri.parse("http://qq.yh31.com/tp/zr/zr195.gif"))//设置uri
                 .setUri(Uri.parse("http://img.huofar.com/data/jiankangrenwu/shizi.gif"))//设置uri
                .build();
        holder.item_cross_image.setController(mDraweeController);
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMImage image = new UMImage(context, "http://img.huofar.com/data/jiankangrenwu/shizi.gif");//网络图片

                new ShareAction((Activity) context)
                        .withMedia(image)
                        .withText("一刻钟")
                        .setDisplayList(/*SHARE_MEDIA.SINA,*/SHARE_MEDIA.QQ/*,SHARE_MEDIA.WEIXIN*/)
                        .setCallback(shareListener)
                        .open();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
     class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView user_head;
        private final SimpleDraweeView item_cross_image;
        private final TextView user_name;
        private final TextView user_time;
        private final TextView item_cross_text;
         private final FloatingActionButton share;

         public MyViewHolder(View itemView) {
            super(itemView);
            user_head = (SimpleDraweeView) itemView.findViewById(R.id.user_head);
            item_cross_image = (SimpleDraweeView) itemView.findViewById(R.id.item_cross_image);
            user_name = (TextView) itemView.findViewById(R.id.user_name);
            user_time = (TextView) itemView.findViewById(R.id.user_time);
            item_cross_text = (TextView) itemView.findViewById(R.id.item_cross_text);
             share = (FloatingActionButton) itemView.findViewById(R.id.share);
        }
    }
}
