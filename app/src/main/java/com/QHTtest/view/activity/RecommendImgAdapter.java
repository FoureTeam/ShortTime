package com.QHTtest.view.activity;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.QHTtest.R;
import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.gui.ninegrideview.LGNineGrideView;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:
 * Thinking:
 * 作者：邹诗惠 on 2017/8/1 16:54
 */

public class RecommendImgAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mList = new ArrayList<>();

    public RecommendImgAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = ((LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.grid_recommended_message,parent,false);
            holder = new ViewHolder();
            holder.grideView=(LGNineGrideView)convertView.findViewById(R.id.nine_gride);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
//        holder.grideView.setUrls(mList.get(position).toString());
        return convertView;
    }

    class ViewHolder {
        LGNineGrideView grideView;
    }
}
