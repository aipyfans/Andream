package com.dream.william.mechanism;

import android.os.Bundle;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

/**
 * 图文详解 Android Binder跨进程通信的原理
 * http://www.jianshu.com/p/4ee3fd07da14
 *
 * Android:远程服务Service(含AIDL&IPC讲解)
 * http://www.jianshu.com/p/34326751b2c6
 */
public class BinderActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder);

    }


}
