package com.hylaa.lib;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.hylaa.lib.net.GtedxHook;

/**
 * HylaaLib.
 * Using this library, you must first initialize it.
 *
 * @author William Lee
 * @version v1.0.0
 * @created 2016-11-7.
 * @tel 152-5320-8570
 */
public class HylaaLib {

    private volatile static HylaaLib hylaaLib;

    private Context mContext;


    private HylaaLib() {
    }

    public static HylaaLib getInstance() {
        if (null == hylaaLib) {
            synchronized (HylaaLib.class) {
                if (null == hylaaLib) {
                    hylaaLib = new HylaaLib();
                }
            }
        }
        return hylaaLib;
    }

    public void init(Context context) {
        if (null == context)
            throw new NullPointerException("{@link Context} must be not null !");

        if (context instanceof Application)
            mContext = context;
        else
            mContext = context.getApplicationContext();
    }

    public Context getContext() {
        if (null == mContext)
            throw new NullPointerException("{@link Context} must be not null !");
        return mContext;
    }


}
