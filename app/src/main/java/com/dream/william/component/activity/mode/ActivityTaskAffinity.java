package com.dream.william.component.activity.mode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

public class ActivityTaskAffinity extends BaseActivity implements View.OnClickListener {

    private Toolbar tbBar;
    private Button btnSingleTaskAffinityStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_affinity);

        Log.e(TAG, "taskId = : " + getTaskId());
        initView();
    }


    private void initView() {
        tbBar = (Toolbar) findViewById(R.id.tb_bar);
        tbBar.setTitle("Task AffinityActivity");
        setSupportActionBar(tbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSingleTaskAffinityStart = (Button) findViewById(R.id.btn_single_task_affinity_start);
        btnSingleTaskAffinityStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_single_task_affinity_start:
                startActivity(new Intent(this, ActivityTaskAffinity2.class));
                break;
        }
    }
}
