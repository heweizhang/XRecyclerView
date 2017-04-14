package com.david.recyclerview.adapter.base.callback;

import android.view.View;

/**
 * Created by david on 17/4/14.
 */

public interface OnViewLongClickListener<T> {

    public void onViewLongClick(View view,int pos,T bean);

}
