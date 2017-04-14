package com.david.xrecyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.david.recyclerview.adapter.base.callback.OnViewClickListener;
import com.david.recyclerview.adapter.base.callback.OnViewLongClickListener;
import com.david.xrecyclerview.R;
import com.david.xrecyclerview.adapter.GridAdapter;
import com.david.xrecyclerview.adapter.ListAdapter;
import com.david.xrecyclerview.adapter.MultiItemAdapter;
import com.david.xrecyclerview.entity.DataBean;
import com.david.xrecyclerview.entity.MultiItemBean;
import com.david.xrecyclerview.model.DataModel;
import com.david.xrecyclerview.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 17/3/24.
 */

public class DemoActivity extends AppCompatActivity {
    private int type;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getIntent().getIntExtra("type", Constants.TYPE_LIST);
        setContentView(R.layout.activity_demo);
        initView();
    }

    private void initView() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        if (type == Constants.TYPE_LIST) {
            LinearLayoutManager linearLayout = new LinearLayoutManager(this);
            /*水平方向:LinearLayoutManager.HORIZONTAL*/
//            linearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
            linearLayout.setOrientation(LinearLayoutManager.VERTICAL);
            ListAdapter adapter = new ListAdapter(this, DataModel.initListData(this));
            recyclerView.setLayoutManager(linearLayout);
            recyclerView.setAdapter(adapter);

        } else if (type == Constants.TYPE_GRID) {
            GridLayoutManager manager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(manager);
            GridAdapter gridAdapter = new GridAdapter();
            recyclerView.setAdapter(gridAdapter);
            gridAdapter.refreshData(DataModel.initListData(this));

            gridAdapter.setOnViewClickListener(new OnViewClickListener<DataBean>() {
                @Override
                public void onViewClick(View view, int pos, DataBean bean) {
                    Toast.makeText(DemoActivity.this, "onViewClick pos:" + pos + ",content:" + bean.getContent(), Toast.LENGTH_SHORT).show();
                }
            });

            gridAdapter.setOnViewLongClickListener(new OnViewLongClickListener<DataBean>() {
                @Override
                public void onViewLongClick(View view, int pos, DataBean bean) {
                    Toast.makeText(DemoActivity.this, "onViewLongClick pos:" + pos + ",content:" + bean.getContent(), Toast.LENGTH_SHORT).show();
                }
            });

        } else if (type == Constants.TYPE_WATERFUL) {

        } else if (type == Constants.MULTI_LIST) {
            LinearLayoutManager linearLayout = new LinearLayoutManager(this);
            linearLayout.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayout);

            MultiItemAdapter adapter = new MultiItemAdapter(this);
            recyclerView.setAdapter(adapter);

            adapter.setOnViewClickListener(new OnViewClickListener<MultiItemBean>() {
                @Override
                public void onViewClick(View view, int pos, MultiItemBean bean) {
                    Toast.makeText(DemoActivity.this, "onViewClick pos:" + pos + ",content:" + bean.getMsg(), Toast.LENGTH_SHORT).show();

                }
            });

            adapter.setOnViewLongClickListener(new OnViewLongClickListener<MultiItemBean>() {
                @Override
                public void onViewLongClick(View view, int pos, MultiItemBean bean) {
                    Toast.makeText(DemoActivity.this, "onViewLongClick pos:" + pos + ",content:" + bean.getMsg(), Toast.LENGTH_SHORT).show();

                }
            });

            adapter.refreshData(DataModel.getMultiData());
        }
    }


}
