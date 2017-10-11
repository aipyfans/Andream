package com.dream.william.lib.rxbinding;

import android.os.Bundle;

import com.dream.william.lib.R;
import com.dream.william.lib.app.BaseActivity;

public class RxBindActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rx_bind);
        setTitle("RxBinding");
    }
}
