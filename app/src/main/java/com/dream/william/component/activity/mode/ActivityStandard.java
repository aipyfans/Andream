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

public class ActivityStandard extends BaseActivity implements View.OnClickListener {

    private Toolbar tbBar;
    private TextView tvDesc;
    private Button btnStandardStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);

        initView();
        Log.w(TAG,"onCreate 新实例 = : " + toString());
        Log.e(TAG, "taskId = : " + getTaskId());
    }

    private void initView() {
        tbBar = (Toolbar) findViewById(R.id.tb_bar);
        tbBar.setTitle("Standard Activity");
        setSupportActionBar(tbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvDesc = (TextView) findViewById(R.id.tv_desc);
        btnStandardStart = (Button) findViewById(R.id.btn_standard_start);

        btnStandardStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_standard_start:
                startActivity(new Intent(this, ActivityStandard.class));
                break;
        }
    }
}
