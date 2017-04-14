package com.david.xrecyclerview.model;

import android.content.Context;

import com.david.xrecyclerview.R;
import com.david.xrecyclerview.entity.DataBean;
import com.david.xrecyclerview.entity.MultiItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 17/3/29.
 */

public class DataModel {

    public static List<DataBean> initListData(Context context) {

        List<DataBean> list = new ArrayList<>();
        list.add(new DataBean(R.drawable.abc1, context.getResources().getString(R.string.op_image_url)));
        list.add(new DataBean(R.drawable.abc2, context.getResources().getString(R.string.op_subtext)));
        list.add(new DataBean(R.drawable.abc2, context.getResources().getString(R.string.op_subtext)));
        list.add(new DataBean(R.drawable.abc3, context.getResources().getString(R.string.op_summarytext)));
        list.add(new DataBean(R.drawable.abc2, context.getResources().getString(R.string.op_subtext)));
        list.add(new DataBean(R.drawable.abc3, context.getResources().getString(R.string.op_summarytext)));
        list.add(new DataBean(R.drawable.abc2, context.getResources().getString(R.string.op_subtext)));
        list.add(new DataBean(R.drawable.abc2, context.getResources().getString(R.string.op_subtext)));
        list.add(new DataBean(R.drawable.abc3, context.getResources().getString(R.string.op_summarytext)));
        list.add(new DataBean(R.drawable.abc3, context.getResources().getString(R.string.op_summarytext)));
        list.add(new DataBean(R.drawable.abc2, context.getResources().getString(R.string.op_subtext)));
        list.add(new DataBean(R.drawable.abc2, context.getResources().getString(R.string.op_subtext)));
        list.add(new DataBean(R.drawable.abc2, context.getResources().getString(R.string.op_subtext)));

        return list;
    }


    public static List<MultiItemBean> getMultiData() {
        List<MultiItemBean> list = new ArrayList<>();
        list.add(new MultiItemBean(0, "item type 0 "));
        list.add(new MultiItemBean(1, "item type 1 "));
        list.add(new MultiItemBean(1, "item type 1"));
        list.add(new MultiItemBean(0, "item type 0"));
        list.add(new MultiItemBean(0, "item type 0"));
        list.add(new MultiItemBean(1, "item type 1 "));
        return list;

    }


}
