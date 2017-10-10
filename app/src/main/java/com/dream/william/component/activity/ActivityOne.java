package com.dream.william.component.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

public class ActivityOne extends BaseActivity {

    private Toolbar mTbBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        Log.w(TAG, "onCreate");
        initView();
    }

    private void initView() {
        mTbBar = (Toolbar) findViewById(R.id.tb_bar);
        mTbBar.setTitle("First Activity");

        setSupportActionBar(mTbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void onClick(View view){
        startActivity(new Intent(this,ActivityTwo.class));
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.w(TAG, "onStart");
    }


    @Override
    protected void onRestart() {
        super.onRestart();

        Log.w(TAG, "onRestart");
    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.w(TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();

        Log.w(TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();

        Log.w(TAG, "onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.w(TAG, "onDestroy");
    }


}
