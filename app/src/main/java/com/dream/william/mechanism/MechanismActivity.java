package com.dream.william.mechanism;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

public class MechanismActivity extends BaseActivity {


    private Toolbar tbBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mechanism);
        initView();
    }

    private void initView() {
        tbBar = findViewById(R.id.tb_bar);
        tbBar.setTitle("Android 各种机制");

        setSupportActionBar(tbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public void onClick(View view) {
        int id = view.getId();
        switch (id) {

            case R.id.btn_handler:
                startActivity(new Intent(this, HandlerActivity.class));
                break;

            case R.id.btn_binder:
                startActivity(new Intent(this, BinderActivity.class));
                break;

            case R.id.btn_event:
                startActivity(new Intent(this, EventActivity.class));
                break;

        }
    }


}
