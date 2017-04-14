package com.david.recyclerview.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.david.recyclerview.adapter.base.entity.MultiItemEntity;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by david on 17/4/14.
 */

public abstract class BaseMultiItemAdapter<T extends MultiItemEntity,V extends BaseViewHolder>  extends BaseAdapter<T,V>{

    private Context context;

    /**
     * layouts indexed with their types
     */
    private SparseArray<Integer> layoutResIds;

    protected void addItemType(Context context,int type, int layoutResId) {
        this.context = context;
        if (layoutResIds == null) {
            layoutResIds = new SparseArray<>();
        }
        layoutResIds.put(type, layoutResId);
    }


    private static final int DEFAULT_VIEW_TYPE = -0xff;

    /**
     * 返回itemType
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if ( valuesList != null || valuesList.size() != 0) {
            Object item = valuesList.get(position);
            if (item instanceof MultiItemEntity) {
                return ((MultiItemEntity) item).getItemType();
            }
        }
        return DEFAULT_VIEW_TYPE;
    }

    private int getLayoutId(int viewType) {
        return layoutResIds.get(viewType);
    }

    /**
     * override onCreateViewHolder()
     * @param parent
     * @param viewType use getLayoutId（viewType） get current item type layout id
     * @return
     */
    @Override
    public V onCreateViewHolder(ViewGroup parent, int viewType) {
        V v = (V) createMultiItemBaseViewHolder(getItemView(getLayoutId(viewType),parent));
        v.setAdapter(this);
        return v;
    }


    @Override
    public void onBindViewHolder(V holder, int position) {
        super.onBindViewHolder(holder, position);
    }


    protected View getItemView(int layoutResId,ViewGroup parent) {
        return LayoutInflater.from(context).inflate(layoutResId, parent, false);
    }

    /**
     * if you want to use subclass of BaseViewHolder in the adapter,
     * you must override the method to create new ViewHolder.
     *
     * @param view view
     * @return new ViewHolder
     */
    protected RecyclerView.ViewHolder createMultiItemBaseViewHolder(final View view) {

        return new BaseViewHolder(view);
    }

    /**
     * implement this method and use the helper to adapt the view to give item
     *
     * @param holder A fully initialized helper.
     * @param item The item that needs to be displayed.
     */
    protected abstract void bind(V holder, T item);
}
