package com.david.xrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.david.xrecyclerview.R;
import com.david.xrecyclerview.entity.DemoBean;

import java.util.List;

/**
 * Created by david on 17/3/28.
 */

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<DemoBean> data;

    public ListAdapter(Context context, List<DemoBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_list, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Glide.with(context).load(data.get(position).getImageId()).into(((ItemViewHolder) holder).iv_pic);
        ((ItemViewHolder) holder).tv_content.setText(data.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_pic;
        private TextView tv_content;

        public ItemViewHolder(View itemView) {
            super(itemView);
            iv_pic = (ImageView) itemView.findViewById(R.id.iv_pic);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
