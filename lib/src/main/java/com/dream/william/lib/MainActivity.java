package com.dream.william.lib;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dream.william.lib.app.BaseActivity;
import com.dream.william.lib.glide.GlideActivity;
import com.dream.william.lib.gson.GsonActivity;
import com.dream.william.lib.okhttp.OkhttpActivity;
import com.dream.william.lib.retrofit.RetrofitActivity;
import com.dream.william.lib.rxandroid.RxAndroidActivity;
import com.dream.william.lib.rxbinding.RxBindActivity;
import com.dream.william.lib.rxjava.RxJavaActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setTitle("不为繁华易匠心  不舍初心得始终");
    }


    public void onClick(View view) {
        int id = view.getId();
        switch (id) {

            case R.id.btn_glide:
                startActivity(new Intent(this, GlideActivity.class));
                break;

            case R.id.btn_gson:
                startActivity(new Intent(this, GsonActivity.class));
                break;

            case R.id.btn_ok_http:
                startActivity(new Intent(this, OkhttpActivity.class));
                break;

            case R.id.btn_retrofit:
                startActivity(new Intent(this, RetrofitActivity.class));
                break;

            case R.id.btn_rx_android:
                startActivity(new Intent(this, RxAndroidActivity.class));
                break;

            case R.id.btn_rx_binding:
                startActivity(new Intent(this, RxBindActivity.class));
                break;

            case R.id.btn_rx_java:
                startActivity(new Intent(this, RxJavaActivity.class));
                break;

            case R.id.btn_:

                break;
        }
    }
}
