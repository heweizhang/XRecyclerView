package com.david.xrecyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.david.xrecyclerview.R;
import com.david.xrecyclerview.adapter.ListAdapter;
import com.david.xrecyclerview.entity.DemoBean;
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
            ListAdapter adapter = new ListAdapter(this, initData());
            recyclerView.setLayoutManager(linearLayout);
            recyclerView.setAdapter(adapter);

        } else if (type == Constants.TYPE_GRID) {

        } else {

        }
    }


    private List<DemoBean> initData() {

        List<DemoBean> list = new ArrayList<>();
        list.add(new DemoBean(R.drawable.abc1, getResources().getString(R.string.op_image_url)));
        list.add(new DemoBean(R.drawable.abc2, getResources().getString(R.string.op_subtext)));
        list.add(new DemoBean(R.drawable.abc3, getResources().getString(R.string.op_summarytext)));
        list.add(new DemoBean(R.drawable.abc2, getResources().getString(R.string.op_subtext)));

        return list;
    }
}
