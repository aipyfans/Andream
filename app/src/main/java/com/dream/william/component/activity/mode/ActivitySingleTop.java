package com.dream.william.component.activity.mode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;
import com.dream.william.component.activity.lifecycle.ActivityTwo;

public class ActivitySingleTop extends BaseActivity implements View.OnClickListener {

    private Toolbar tbBar;
    private TextView tvDesc;

    private Button btnSingleTopStart;
    private Button btnStandardStart;

    private int num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top);

        initView();
        Log.w(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.w(TAG, "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.w(TAG, "onResume 实例 = : " + toString());
        Log.e(TAG, "taskId = : " + getTaskId());
    }

    private void initView() {
        tbBar = (Toolbar) findViewById(R.id.tb_bar);
        tbBar.setTitle("Single Top Activity");
        setSupportActionBar(tbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvDesc = (TextView) findViewById(R.id.tv_desc);
        btnSingleTopStart = (Button) findViewById(R.id.btn_single_top_start);
        btnStandardStart = (Button) findViewById(R.id.btn_standard_start);

        btnSingleTopStart.setOnClickListener(this);
        btnStandardStart.setOnClickListener(this);

    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Log.e(TAG, intent.getStringExtra(TAG));
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_single_top_start:
                Intent intent = new Intent(this, ActivitySingleTop.class);
                intent.putExtra(TAG, "number = " + String.valueOf(num++));
                startActivity(intent);
                break;

            case R.id.btn_standard_start:
                startActivity(new Intent(this, ActivityTwo.class));
                break;
        }
    }
}
