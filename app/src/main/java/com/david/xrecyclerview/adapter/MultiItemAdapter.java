package com.david.xrecyclerview.adapter;

import android.content.Context;
import android.widget.TextView;

import com.david.recyclerview.adapter.base.BaseAdapter;
import com.david.recyclerview.adapter.base.BaseMultiItemAdapter;
import com.david.recyclerview.adapter.base.BaseViewHolder;
import com.david.recyclerview.adapter.base.entity.MultiItemEntity;
import com.david.xrecyclerview.R;
import com.david.xrecyclerview.entity.DataBean;
import com.david.xrecyclerview.entity.MultiItemBean;

/**
 * Created by david on 17/4/14.
 */

public class MultiItemAdapter extends BaseMultiItemAdapter<MultiItemBean,BaseViewHolder> {

    public MultiItemAdapter(Context context) {
        addItemType(context, 0, R.layout.item_rv_funcs);
        addItemType(context, 1, R.layout.item_rv_funcs2);
    }

    @Override
    protected void bind(BaseViewHolder holder, MultiItemBean item) {
        switch (holder.getItemViewType()) {

            case 0:
                TextView textView = holder.getView(R.id.tv_func_name);
                textView.setText(item.getMsg());

                holder.addViewOnClickListener(R.id.tv_func_name);

                break;
            case 1:
                TextView tv = holder.getView(R.id.tv_func_name2);
                tv.setText(item.getMsg());

                holder.addViewLongClickListener(R.id.tv_func_name2);
                break;

        }
    }
}
