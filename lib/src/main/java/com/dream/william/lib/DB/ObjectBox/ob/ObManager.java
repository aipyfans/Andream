package com.dream.william.lib.DB.ObjectBox.ob;

import android.content.Context;

import com.dream.william.lib.DB.ObjectBox.model.MyObjectBox;

import io.objectbox.BoxStore;

/**
 * Created by william on 12/15/17.
 */

public class ObManager {

    private static final ObManager ourInstance = new ObManager();

    public static ObManager getInstance() {
        return ourInstance;
    }

    private ObManager() {

    }

    private BoxStore mBoxStore;

    public void init(Context context) {
        mBoxStore = MyObjectBox.builder().androidContext(context).build();
    }

    public BoxStore getBoxStore() {
        return mBoxStore;
    }

}
