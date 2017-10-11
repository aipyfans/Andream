package com.hylaa.lib.net.common;

import android.util.Log;

import com.hylaa.lib.net.error.ErrorFactory;
import com.hylaa.lib.net.error.NetError;
import com.hylaa.lib.net.model.BaseJson;

import rx.Subscriber;

/**
 * Default subscriber base class to be used whenever you want default error handling.
 */
public abstract class SubscriberNet<T> extends Subscriber<T> {

    private static final String TAG = SubscriberNet.class.getSimpleName();

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG,null == e.getMessage() ? "":e.getMessage());

        NetError ne = ErrorFactory.create(e);
        onGtedxError(ne);
    }

    @Override
    public void onNext(T t) {
        BaseJson bj = (BaseJson) t;
        int code = bj.getCode();

        if (200 != code) {
            NetError error = bj.getError();
            onGtedxError(error);

            Log.e(TAG,error.getMsg());
        } else {
            onGtedxNext(t);
        }
    }

    protected abstract void onGtedxNext(T t);

    protected abstract void onGtedxError(NetError ne);

}
