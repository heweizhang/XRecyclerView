package com.david.xrecyclerview.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.david.xrecyclerview.R;
import com.david.xrecyclerview.utils.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, DemoActivity.class).putExtra("type", Constants.TYPE_LIST));

            }
        });
        findViewById(R.id.btn_grid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, DemoActivity.class).putExtra("type", Constants.TYPE_GRID));

            }
        });
        findViewById(R.id.btn_waterful).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, DemoActivity.class).putExtra("type", Constants.TYPE_WATERFUL));

            }
        });


    }
}
