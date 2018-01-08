package com.dream.william.lib.app;

import android.app.Application;

import com.dream.william.lib.DB.ObjectBox.ob.ObManager;
import com.dream.william.lib.DB.Room.UsersDatabase;

/**
 * Created by william on 8/17/17.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // DB-ObjectBox
        ObManager.getInstance().init(this);

        // DB-Room
        UsersDatabase.getInstance(this);
    }
}
