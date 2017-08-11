package com.QHTtest.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.QHTtest.R;
import com.QHTtest.model.bean.CrossTalkFragBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 仇海涛 on 2017/8/8.
 * class ：
 * content ：
 */

public class CrossFragAdapter extends Adapter<CrossFragAdapter.MyViewHolder> {
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
    public void onBindViewHolder(MyViewHolder holder, int position) {
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

        public MyViewHolder(View itemView) {
            super(itemView);
            user_head = (SimpleDraweeView) itemView.findViewById(R.id.user_head);
            item_cross_image = (SimpleDraweeView) itemView.findViewById(R.id.item_cross_image);
            user_name = (TextView) itemView.findViewById(R.id.user_name);
            user_time = (TextView) itemView.findViewById(R.id.user_time);
            item_cross_text = (TextView) itemView.findViewById(R.id.item_cross_text);

        }
    }
}
