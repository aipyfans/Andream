package com.william.dream.push;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by william on 11/20/17.
 */

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        JPushInterface.setDebugMode(BuildConfig.DEBUG);
        JPushInterface.init(this);
    }

}
