package com.dream.william.lib.app;

import android.app.Application;

import com.dream.william.lib.DB.ObjectBox.ob.ObManager;

/**
 * Created by william on 8/17/17.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ObManager.getInstance().init(this);
    }
}
