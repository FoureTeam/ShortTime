package com.QHTtest.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.QHTtest.R;
import com.QHTtest.model.bean.HomeBean;
import com.QHTtest.presenter.HomePresenter;
import com.QHTtest.view.iview.Recy_OnClick;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ASUS on 2017/6/14.
 */

public class RecommendFragRecyLeftAda extends RecyclerView.Adapter<RecommendFragRecyLeftAda.MyViewHolder> {
    Context context;
    List<HomeBean.DatasBean.ClassListBean> class_list = new ArrayList<>();
    private Recy_OnClick onClick;
    private HomePresenter presenter;
    public void setOnClick(Recy_OnClick recy_onClick){
        this.onClick = recy_onClick;
    }
    public RecommendFragRecyLeftAda(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = View.inflate(context, R.layout.home_recy_item,null);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getLayoutPosition();
                String gc_id = class_list.get(position).getGc_id();
                onClick.onClick(v,position,gc_id);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //Glide.with(context).load(class_list.get(position).getImage()).placeholder(R.mipmap.ic_normal_class).into(holder.imageView);
        presenter.setImg(context,class_list.get(position).getImage(),holder.imageView);
        holder.textView.setText(class_list.get(position).getGc_name());
    }

    @Override
    public int getItemCount() {
        return class_list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imageView;
        private final TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.home_recy_item_ImageView);
            textView = (TextView) itemView.findViewById(R.id.home_item_TextView);
        }
    }
    public void setData(List<HomeBean.DatasBean.ClassListBean> data, HomePresenter presenter){
        this.class_list = data;
        this.presenter = presenter;
        notifyDataSetChanged();
    }
}
