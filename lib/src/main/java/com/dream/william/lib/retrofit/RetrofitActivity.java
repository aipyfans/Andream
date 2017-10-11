package com.dream.william.lib.retrofit;

import android.os.Bundle;

import com.dream.william.lib.R;
import com.dream.william.lib.app.BaseActivity;

public class RetrofitActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_retrofit);
        setTitle("Retrofit");
    }
}
