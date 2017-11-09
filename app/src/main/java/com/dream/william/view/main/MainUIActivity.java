package com.dream.william.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;
import com.dream.william.view.widget.TabLayoutActivity;

public class MainUIActivity extends BaseActivity {


    private Toolbar tbBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ui);


        tbBar = (Toolbar) findViewById(R.id.tb_bar);
        tbBar.setTitle("UI Architecture");

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
            case R.id.btn_wechat:
                startActivity(new Intent(this, MainBottomActivity.class));
                break;
            case R.id.btn_slider:
                startActivity(new Intent(this, MainSlideActivity.class));
                break;
            case R.id.btn_nav_slide:
                startActivity(new Intent(this, MainBSActivity.class));
                break;
            case R.id.btn_nav_tab:
                startActivity(new Intent(this, TabLayoutActivity.class));
                break;


        }
    }


}
