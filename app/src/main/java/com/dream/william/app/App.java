package com.dream.william.app;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;

/**
 * Created by william on 8/17/17.
 */

public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        Stetho.initialize(Stetho.newInitializerBuilder(this).enableDumpapp(Stetho.defaultDumperPluginsProvider(this)).enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build()).build());

        mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
