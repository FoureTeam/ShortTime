package com.QHTtest.view.constom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Title:
 * Thinking:
 * 作者：邹诗惠 on 2017/7/28 21:38
 */

public class DividerView extends RecyclerView.ItemDecoration {
    Context mContext;

    public DividerView(Context context) {
        this.mContext = context;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state); 
        int count = parent.getChildCount();
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        for (int i = 0; i < count; i++) {
            View view = parent.getChildAt(i);
            int left = view.getLeft();
            int right = view.getRight();
            int top = view.getBottom();
            int bottom = view.getBottom()+2;
            c.drawRect(left,top,right,bottom,paint);
        }

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

    }
}
