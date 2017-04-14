package com.david.xrecyclerview.adapter;


import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.david.recyclerview.adapter.base.BaseAdapter;
import com.david.recyclerview.adapter.base.BaseViewHolder;
import com.david.xrecyclerview.AppContext;
import com.david.xrecyclerview.R;
import com.david.xrecyclerview.entity.DataBean;

/**
 * Created by david on 17/4/14.
 */

public class GridAdapter extends BaseAdapter<DataBean, BaseViewHolder> {

    public GridAdapter() {
        super(R.layout.item_rv_list);
    }

    @Override
    protected void bind(BaseViewHolder holder, DataBean item) {

        holder.addViewOnClickListener(R.id.tv_content);
        holder.addViewLongClickListener(R.id.iv_pic);

        ImageView view = holder.getView(R.id.iv_pic);
        Glide.with(AppContext.getInstance()).load(item.getImageId()).into(view);
        TextView tv = holder.getView(R.id.tv_content);
        tv.setText(item.getContent());
    }
}
