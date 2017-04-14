package com.david.xrecyclerview.entity;


import com.david.recyclerview.adapter.base.entity.MultiItemEntity;

/**
 * Created by david on 17/4/13.
 */

public class MultiItemBean implements MultiItemEntity {

    private int itemType;

    private String msg;

    public MultiItemBean(int itemType, String msg) {
        this.itemType = itemType;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public int getItemType() {
        return itemType;
    }


}
