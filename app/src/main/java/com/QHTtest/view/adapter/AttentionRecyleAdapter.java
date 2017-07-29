package com.QHTtest.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.QHTtest.R;
import com.QHTtest.view.constom.AttentionView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.x;

/**
 * Title:
 * Thinking:
 * 作者：邹诗惠 on 2017/7/28 19:20
 */

public class AttentionRecyleAdapter extends RecyclerView.Adapter {

    private Context mcontext;
    private List<String> list = new ArrayList<>();

    public AttentionRecyleAdapter(Context context) {
        this.mcontext = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mcontext, R.layout.attention_details_recycler, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.attentionView.setUserName(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<String> data) {
        if (data != null) {
            list.addAll(data);
        }
    }

  public  class MyViewHolder extends RecyclerView.ViewHolder {


      private final AttentionView attentionView;

      public MyViewHolder(View itemView) {
            super(itemView);
          attentionView = (AttentionView) itemView.findViewById(R.id.attentionView_recy);
        }
    }

    public void AddHeaderItem(List<String> list) {
        this.list.addAll(0, list);
        notifyDataSetChanged();
    }

}
