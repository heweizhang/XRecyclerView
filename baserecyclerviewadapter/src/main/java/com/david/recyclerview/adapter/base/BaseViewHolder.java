package com.david.recyclerview.adapter.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.*;

/**
 * Created by david on 17/4/14.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    /**
     * 稀疏数组(SparseArray):
     * SparseArray是android里为<Interger,Object> 这样的Hashmap而专门写的类,目的是提高效率，其核心是折半查找函数（binarySearch）。
     * 在Android中，当我们需要定义 HashMap <Integer, E> hashMap = new HashMap <Integer, E> ();
     * 时，我们可以使用如下的方式来取得更好的性能.
     * SparseArray <E> sparseArray = new SparseArray <E> ();
     */

    private final SparseArray<View> views;
    private View convertView;
    private BaseAdapter adapter;

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.views = new SparseArray<>();
        this.convertView = itemView;
    }

    public View getConvertView() {
        return convertView;
    }

    /**
     * Sets the adapter of a adapter view.
     *
     * @param adapter The adapter;
     * @return The BaseViewHolder for chaining.
     */
    protected BaseViewHolder setAdapter(BaseAdapter adapter) {
        this.adapter = adapter;
        return this;
    }


    /**
     * getView from holder
     * 首次获取view时，通过convertView来获取view并由views来维护
     *
     * @param viewId
     * @param <T>    控件类型
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * view的点击事件
     * 先判断adapter.getOnViewClickListener() ！= null,
     * 确认设置点击事件监听后
     * 通过adapter.getItemData(int pos) 获取bean
     * 返回callbak必须的信息
     *
     * @param viewId
     * @return
     */
    public BaseViewHolder addViewOnClickListener(final int viewId) {

        View view = getView(viewId);
        if(view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (adapter != null && adapter.getOnViewClickListener() != null) {
                        adapter.getOnViewClickListener().onViewClick(view,getLayoutPosition(),adapter.getItemData(getLayoutPosition()));
                    }
                }
            });
        }

        return this;
    }

    /**
     * view的长按事件监听
     * 先判断adapter.getOnViewLongClickListener() ！= null,
     * 确认设置点击事件监听后
     * 通过adapter.getItemData(int pos) 获取bean
     * 返回callbak必须的信息
     *
     * @param viewId
     * @return
     */
    public BaseViewHolder addViewLongClickListener(final int viewId) {

        View view = getView(viewId);
        if(view != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    if (adapter != null && adapter.getOnViewLongClickListener() != null) {
                        adapter.getOnViewLongClickListener().onViewLongClick(view,getLayoutPosition(),adapter.getItemData(getLayoutPosition()));
                    }
                    return false;
                }
            });
        }

        return this;
    }


}
