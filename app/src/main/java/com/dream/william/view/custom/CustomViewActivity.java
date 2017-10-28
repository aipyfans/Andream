package com.dream.william.view.custom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;
import com.dream.william.view.custom.hencoder.HenCoder1Activity;

public class CustomViewActivity extends BaseActivity {


    private Toolbar tbBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        initView();
    }


    private void initView() {

        tbBar = (Toolbar) findViewById(R.id.tb_bar);
        tbBar.setTitle("Custom View Activity");

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

            case R.id.btn_draw:
                startActivity(new Intent(this, HenCoder1Activity.class));
                break;

        }
    }
}
