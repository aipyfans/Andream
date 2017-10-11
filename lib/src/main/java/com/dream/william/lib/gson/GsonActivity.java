package com.dream.william.lib.gson;

import android.os.Bundle;

import com.dream.william.lib.R;
import com.dream.william.lib.app.BaseActivity;

public class GsonActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gson);
        setTitle("Gson");
    }
}
