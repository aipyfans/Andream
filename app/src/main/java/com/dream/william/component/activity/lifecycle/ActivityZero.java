package com.dream.william.component.activity.lifecycle;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

public class ActivityZero extends BaseActivity {

    private Toolbar mTbBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);

        Log.w(TAG, "onCreate");
        if (savedInstanceState != null) {
            String saveResult = savedInstanceState.getString("William", "Lee");
            Log.e(TAG, saveResult);
        }
        initView();
    }

    private void initView() {
        mTbBar = (Toolbar) findViewById(R.id.tb_bar);
        mTbBar.setTitle("Zero Activity");

        setSupportActionBar(mTbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    /**
     * 此钩子函数:在onStop()之前调用,同时有可能在onPause()之前或者之后调用.
     * <p>
     * 当Activity异常情况下需要重新创建时,系统会默认为我们保存当前Activity的视图结构,并且在Activity重启后为我们恢复这些数据.
     * 比如文本框中用户输入的数据,ListView滚动的位置等,这些View相关的状态系统都能够默认为我们恢复.
     * <p>
     * 通过横竖屏查看此页面的EditText控件中输入的文本,可以测试得出这个结论.
     *
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.e(TAG, "onSaveInstanceState");
        outState.putString("William", "Dream");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.e(TAG, "onRestoreInstanceState");
        String saveResult = savedInstanceState.getString("William", "Lee");
        Log.e(TAG, saveResult);
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
