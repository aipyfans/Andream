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

    /**
     * 此实例每次使用都必须重新实例化.
     *
     * @param context      ProgressDialog 所需窗口的Context
     * @param isCancelable ProgressDialog 是否可以通过触摸关闭
     */
    public SubscriberNet(Context context, boolean isCancelable) {
        this.mContext = context;
        mPDHandler = new ProgressDialogHandler(context, this, isCancelable);
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
        String msg = ErrorFactory.create(mContext, e);
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();

        hideLoading();
    }


    /**
     * 统一做了相同格式的Http请求返回结果的数据封装以及根据返回结果的状态码进行的预处理.
     *
     * @param t
     */
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
            mContext = null;
        }
    }


    protected abstract void onGtedxNext(T t);


    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
            mContext = null;
        }
    }

}
