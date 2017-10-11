package com.hylaa.lib.net.common;

import android.content.Context;
import android.widget.Toast;

import com.hylaa.lib.net.error.ErrorFactory;
import com.hylaa.lib.net.model.BaseJson;
import com.hylaa.lib.net.progress.ProgressCancelListener;
import com.hylaa.lib.net.progress.ProgressDialogHandler;

import rx.Subscriber;

/**
 * Default subscriber base class to be used whenever you want default error handling.
 */
public abstract class SubscriberNet<T> extends Subscriber<T> implements ProgressCancelListener {

    private Context mContext;

    private ProgressDialogHandler mPDHandler;

    public SubscriberNet(Context context) {
        this.mContext = context;
        mPDHandler = new ProgressDialogHandler(context, this, true);
    }


    @Override
    public void onStart() {
        showLoading();
    }


    @Override
    public void onCompleted() {
        hideLoading();
    }


    @Override
    public void onError(Throwable e) {
        hideLoading();

        String msg = ErrorFactory.create(mContext, e);
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onNext(T t) {
        BaseJson bj = (BaseJson) t;
        int code = bj.getCode();

        if (NetConst.HttpCode.HC_OK != code) {
            throw bj.getError();
        } else {
            onGtedxNext(t);
        }
    }


    /**
     * 遇到列表形式的视图可以覆盖其样式.
     */
    public void showLoading() {
        if (mPDHandler != null) {
            mPDHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }


    /**
     * 遇到列表形式的视图可以覆盖其样式.
     */
    public void hideLoading() {
        if (mPDHandler != null) {
            mPDHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mPDHandler = null;
            mContext = null; // TODO 有可能会报错,待测试
        }
    }


    protected abstract void onGtedxNext(T t);


    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
            mContext = null; // TODO 有可能会报错,待测试
        }
    }

}
