package com.dream.william.component.activity.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

/**
 * https://mp.weixin.qq.com/s?__biz=MzA3NTYzODYzMg==&mid=2653579375&idx=1&sn=4f80a50961329e19cad6cd0e1bff20d9&chksm=84b3ba68b3c4337e28a870d6338fa3035d299a2aff2f3bf3f82304417aa7a83deab0b95031e6&scene=0&pass_ticket=qq9xX1Ljey40ULpbxN9%2FVcf1GPZ%2BI1SFQU1KVdF6nSIQN74KFsqKT5TlxgY9g4%2Bm##
 */
public class FragmentTestActivity extends BaseActivity {

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    private Toolbar tbBar;

    DialogProgressFragment fragment = DialogProgressFragment.newInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "[onCreate] Begin");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);


        tbBar = (Toolbar) findViewById(R.id.tb_bar);
        tbBar.setTitle("Fragment Activity");

        setSupportActionBar(tbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (savedInstanceState == null) {
            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction = mFragmentManager.beginTransaction();

            Fragment1 fragmentOne = Fragment1.newInstance("hello", "world");
            mFragmentTransaction.add(R.id.fl_container, fragmentOne, "fragmentTag");
            // mFragmentTransaction.addToBackStack(Fragment1.class.getSimpleName());
            mFragmentTransaction.commit();

        }
        Log.e(TAG, "[onCreate] End");
    }


    public void onClick(View view){
        fragment.show(getSupportFragmentManager(), "progressDialog");
        new Thread() {
            public void run() {
                SystemClock.sleep(5000);
                if (fragment == null) {
                    fragment = (DialogProgressFragment) getSupportFragmentManager().findFragmentByTag("progressDialog");
                }
                fragment.dismiss();
            }
        }.start();
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        Log.e(TAG, "[onPostCreate] Begin");
        super.onPostCreate(savedInstanceState);
        Log.e(TAG, "[onPostCreate] End");
    }


    @Override
    public void onAttachFragment(Fragment fragment) {
        Log.e(TAG, "[onAttachFragment] Begin");
        super.onAttachFragment(fragment);
        Log.e(TAG, "[onAttachFragment] End");
    }


    @Override
    protected void onRestart() {
        Log.e(TAG, "[onRestart] Begin");
        super.onRestart();
        Log.e(TAG, "[onRestart] End");
    }


    @Override
    protected void onStart() {
        Log.e(TAG, "[onStart] Begin");
        super.onStart();
        Log.e(TAG, "[onStart] End");
    }


    @Override
    protected void onResume() {
        Log.e(TAG, "[onResume] Begin");
        super.onResume();
        Log.e(TAG, "[onResume] End");
    }


    @Override
    public void onAttachedToWindow() {
        Log.e(TAG, "[onAttachedToWindow] Begin");
        super.onAttachedToWindow();
        Log.e(TAG, "[onAttachedToWindow] End");
    }


    @Override
    protected void onPostResume() {
        Log.e(TAG, "[onPostResume] Begin");
        super.onPostResume();
        Log.e(TAG, "[onPostResume] End");
    }


    @Override
    protected void onPause() {
        Log.e(TAG, "[onPause] Begin");
        super.onPause();
        Log.e(TAG, "[onPause] End");
    }


    @Override
    protected void onStop() {
        Log.e(TAG, "[onStop] Begin");
        super.onStop();
        Log.e(TAG, "[onStop] End");
    }


    @Override
    protected void onDestroy() {
        Log.e(TAG, "[onDestroy] Begin");
        super.onDestroy();
        Log.e(TAG, "[onDestroy] End");
    }


    @Override
    public void onDetachedFromWindow() {
        Log.e(TAG, "[onDetachedFromWindow] Begin");
        super.onDetachedFromWindow();
        Log.e(TAG, "[onDetachedFromWindow] End");
    }

}

