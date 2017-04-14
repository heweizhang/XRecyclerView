package com.david.recyclerview.adapter.base.callback;

import android.view.View;

/**
 * Created by david on 17/4/14.
 */

public interface OnViewClickListener<T> {
    public void onViewClick( View view, int pos, T bean);
}
