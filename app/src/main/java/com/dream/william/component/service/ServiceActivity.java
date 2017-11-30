package com.dream.william.component.service;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dream.william.R;

/**
 * 服务
 * https://developer.android.com/guide/components/services.html?hl=zh-cn#Notifications
 * <p>
 * 绑定服务
 * https://developer.android.com/guide/components/bound-services.html?hl=zh-cn
 */
public class ServiceActivity extends AppCompatActivity {

    private Toolbar tbBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        initView();
    }

    private void initView() {
        tbBar = findViewById(R.id.tb_bar);
        tbBar.setTitle("Service");

        setSupportActionBar(tbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
