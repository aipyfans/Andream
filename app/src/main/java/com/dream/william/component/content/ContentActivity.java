package com.dream.william.component.content;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

/**
 * https://developer.android.com/guide/topics/providers/content-providers.html?hl=zh-cn
 */
public class ContentActivity extends BaseActivity {

    private Toolbar mTbBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        initView();
    }

    private void initView() {
        mTbBar = findViewById(R.id.tb_bar);
        mTbBar.setTitle("Content Provider");

        setSupportActionBar(mTbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public void onClick(View view) {
        int id = view.getId();
        switch (id) {

            case R.id.btn_user_dictionary:
                startActivity(new Intent(this, CpUserDictionaryActivity.class));
                break;

            case R.id.btn_calendar:
                startActivity(new Intent(this, CpCalendarActivity.class));
                break;

            case R.id.btn_other:

                break;
        }
    }
}
