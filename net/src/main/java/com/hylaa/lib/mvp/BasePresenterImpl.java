package com.hylaa.lib.mvp;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 线程切换|超时设置.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016-12-05
 * @phone 152-5320-8570
 */
public class BasePresenterImpl {

    private CompositeSubscription mSubscriptions;

    public void subscribe() {

    }


    public void unsubscribe() {
        if (mSubscriptions != null && mSubscriptions.hasSubscriptions()) {
            mSubscriptions.clear();
            mSubscriptions.unsubscribe();
        }
    }


    public void clear() {
        if (mSubscriptions != null) {
            mSubscriptions.clear();
        }
    }


    public void add(Subscription subscription) {
        if (null == mSubscriptions) {
            mSubscriptions = new CompositeSubscription();
        }
        mSubscriptions.add(subscription);
    }


    public <T> Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable
                        .timeout(8, TimeUnit.SECONDS)// 任务超时设置为8秒
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    public <T> Observable.Transformer<T, T> delaySchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.delay(2, TimeUnit.SECONDS);// 延迟发送事件-设置为2秒
            }
        };
    }


}
