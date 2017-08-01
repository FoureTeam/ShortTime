package com.QHTtest.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.QHTtest.R;
import com.QHTtest.model.bean.RecommendHotBean;
import com.QHTtest.view.activity.RecommendImgAdapter;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Title:
 * Thinking:
 * 作者：邹诗惠 on 2017/8/1 15:24
 */

public class RecommendHotAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<RecommendHotBean.ResourceBean> list = new ArrayList<>();
    private List<String> imgUri = new ArrayList<>();

    public RecommendHotAdapter(Context context, List<RecommendHotBean.ResourceBean> list) {
        this.mContext = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            //list.get(position).getDictionaryValue().equals("1")
            return 2;
        } else if (list.get(position).getDictionaryValue().equals("2")) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case 0: {
                view = LayoutInflater.from(mContext).inflate(R.layout.recycler_recommended_video, parent, false);
                holder = new ViewHolderOne(view);
                break;
            }
            case 1: {
                view = LayoutInflater.from(mContext).inflate(R.layout.recycler_recommended_img, parent, false);
                holder = new ViewHolderTwo(view);
            }
            break;
            case 2: {
                view = LayoutInflater.from(mContext).inflate(R.layout.recycler_recommended_img, parent, false);
                holder = new ViewHolderTwo(view);
            }
            break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 0: {
                final ViewHolderOne holderOne = (ViewHolderOne) holder;
                holderOne.userNameOne.setText(list.get(position).getUser().getUserName());
                holderOne.introduceOne.setText(list.get(position).getUptime());
                holderOne.describe_video.setText(list.get(position).getContent());
            }
            break;
            case 1: {
                ViewHolderTwo holderTwo = (ViewHolderTwo) holder;
                holderTwo.uploadImg_img.setVisibility(View.GONE);
                holderTwo.userNameTwo.setText(list.get(position).getUser().getUserName());
                holderTwo.introduceTwo.setText(list.get(position).getUptime());
                holderTwo.describe_img.setText(list.get(position).getContent());
                break;
            }
            case 2: {
                ViewHolderTwo holderTwo = (ViewHolderTwo) holder;
                holderTwo.uploadImg_img.setVisibility(View.VISIBLE);
                imgUri.add("http://img06.tooopen.com/images/20160712/tooopen_sy_170083325566.jpg");
                imgUri.add("  http://www.wallcoo.com/cartoon/colors_in_japanese_style/wallpapers/1600x1200/colors_and_flower_pattern_in_japanese_style_wa01_004le.jpg");
                holderTwo.uploadImg_img.setNumColumns(2);
                holderTwo.uploadImg_img.setAdapter(new RecommendImgAdapter(mContext,imgUri));
                holderTwo.userNameTwo.setText(list.get(position).getUser().getUserName());
                holderTwo.introduceTwo.setText(list.get(position).getUptime());
                holderTwo.describe_img.setText(list.get(position).getContent());
            }
            break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderOne extends RecyclerView.ViewHolder {
        private final CircleImageView userImagOne;
        private final TextView userNameOne;
        private final TextView introduceOne;
        private final TextView describe_video;
        private final TextView godCommentsUserOne_video;
        private final TextView godCommentsDetailsOne_video;
        private final TextView godCommentsUserTwo_video;
        private final TextView godCommentsDetailsTwo_video;

        public ViewHolderOne(View itemView) {
            super(itemView);
            userImagOne = (CircleImageView) itemView.findViewById(R.id.userImag_jm);
            userNameOne = (TextView) itemView.findViewById(R.id.userName_jm);
            introduceOne = (TextView) itemView.findViewById(R.id.introduce_jm);
            describe_video = (TextView) itemView.findViewById(R.id.describe_video);
            godCommentsUserOne_video = (TextView) itemView.findViewById(R.id.godCommentsUserOne_video);
            godCommentsDetailsOne_video = (TextView) itemView.findViewById(R.id.godCommentsDetailsOne_video);
            godCommentsUserTwo_video = (TextView) itemView.findViewById(R.id.godCommentsUserTwo_video);
            godCommentsDetailsTwo_video = (TextView) itemView.findViewById(R.id.godCommentsDetailsTwo_video);
        }
    }

    class ViewHolderTwo extends RecyclerView.ViewHolder {
        private final CircleImageView userImagTwo;
        private final TextView userNameTwo;
        private final TextView introduceTwo;
        private final TextView describe_img;
        private final GridView uploadImg_img;
        private final TextView godCommentsUserOne_img;
        private final TextView godCommentsDetailsOne_img;
        private final TextView godCommentsUserTwo_img;
        private final TextView godCommentsDetailsTwo_img;

        public ViewHolderTwo(View itemView) {
            super(itemView);
            userImagTwo = (CircleImageView) itemView.findViewById(R.id.userImag_jm);
            userNameTwo = (TextView) itemView.findViewById(R.id.userName_jm);
            introduceTwo = (TextView) itemView.findViewById(R.id.introduce_jm);
            describe_img = (TextView) itemView.findViewById(R.id.describe_img);
            uploadImg_img = (GridView) itemView.findViewById(R.id.uploadImg_img);
            godCommentsUserOne_img = (TextView) itemView.findViewById(R.id.godCommentsUserOne_img);
            godCommentsDetailsOne_img = (TextView) itemView.findViewById(R.id.godCommentsDetailsOne_img);
            godCommentsUserTwo_img = (TextView) itemView.findViewById(R.id.godCommentsUserTwo_img);
            godCommentsDetailsTwo_img = (TextView) itemView.findViewById(R.id.godCommentsDetailsTwo_img);
        }
    }

    public void addHeaderItem(List<RecommendHotBean.ResourceBean> list) {
        this.list.addAll(0, list);
        notifyDataSetChanged();
    }


}
