package com.david.recyclerview.adapter.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.david.recyclerview.adapter.base.callback.OnViewClickListener;
import com.david.recyclerview.adapter.base.callback.OnViewLongClickListener;

import java.util.List;


/**
 * Created by david on 17/4/14.
 * <p>
 * github：https:github.com/heweizhang/XRecyclerView
 * blog: http:www.hwzhang.top
 *
 * @param <T> item bean类型
 * @param <V> holder
 */
public abstract class BaseAdapter<T, V extends BaseViewHolder> extends RecyclerView.Adapter<V> {

    /**
     * 存放数据bean集合
     */
    protected List<T> valuesList;

    /**
     * item layoutId
     */
    private int layoutId;

    private LayoutInflater layoutInflater;

    public BaseAdapter() {
    }

    /**
     * 只提供一种构造函数，传入layoutId，
     * data首次传入请调用 adapter.refreshData(List<T> valuesList)
     * data追加操作请调用 adapter.setMoreData(List<T> newValuesList)
     *
     * @param layoutId
     */
    public BaseAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    public T getItemData(int position) {
        if (position != -1)
            return valuesList.get(position);
        else
            return null;
    }

    /**
     * 点击事件监听
     */
    private OnViewClickListener<T> onViewClickListener;

    public OnViewClickListener<T> getOnViewClickListener() {
        return onViewClickListener;
    }

    public void setOnViewClickListener(OnViewClickListener<T> onViewClickListener) {
        this.onViewClickListener = onViewClickListener;
    }

    /**
     * 长按事件监听
     */
    private OnViewLongClickListener<T> onViewLongClickListener;

    public void setOnViewLongClickListener(OnViewLongClickListener<T> onViewLongClickListener) {
        this.onViewLongClickListener = onViewLongClickListener;
    }

    public OnViewLongClickListener<T> getOnViewLongClickListener() {
        return onViewLongClickListener;
    }



    /**
     * 初始化数据
     * 数据完全覆盖
     *
     * @param valuesList
     */
    public void refreshData(List<T> valuesList) {
        this.valuesList = valuesList;
        notifyDataSetChanged();
    }

    /**
     * 上拉加载更多数据
     * 数据追加
     * 局部刷新
     *
     * @param newValuesList 新加载的数据
     */
    public void setMoreData(List<T> newValuesList) {

        if (newValuesList == null || newValuesList.size() == 0) {
            return;
        }

        int oldPosition = valuesList == null ? 0 : valuesList.size() - 1;
        this.valuesList.addAll(newValuesList);
        notifyItemRangeInserted(oldPosition, newValuesList.size());
    }


    @Override
    public V onCreateViewHolder(ViewGroup parent, int viewType) {
        this.layoutInflater = LayoutInflater.from(parent.getContext());
        if (layoutId != 0) {
            V viewholder = (V) new BaseViewHolder(layoutInflater.inflate(layoutId, parent, false));
            viewholder.setAdapter(this);
            return viewholder;
        }

        return null;
    }

    /**
     * 数据绑定交给子类
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final V holder, final int position) {

        bind(holder, valuesList.get(position));

    }

    @Override
    public int getItemCount() {
        return valuesList == null ? 0 : valuesList.size();
    }

    /**
     * implement this method and use the helper to adapt the view to give item
     *
     * @param holder A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    protected abstract void bind(V holder, T item);
}
