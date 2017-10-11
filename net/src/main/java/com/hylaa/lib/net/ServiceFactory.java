package com.hylaa.lib.net;


import android.text.TextUtils;

import com.hylaa.lib.net.interceptor.InterceptorToken;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServiceFactory {


    private String mHostPort;

    private GtedxHook mGtedxHook;

    public ServiceFactory(String hostPort) {
        if (TextUtils.isEmpty(hostPort))
            throw new NullPointerException("hostPort must be not null !");
        this.mHostPort = hostPort;
    }


    public String getHostPort() {
        return mHostPort;
    }

    public void setHostPort(String hostPort) {
        mHostPort = hostPort;
    }

    public GtedxHook getGtedxHook() {
        return mGtedxHook;
    }

    public void setGtedxHook(GtedxHook gtedxHook) {
        mGtedxHook = gtedxHook;
    }


    /**
     * Creates a retrofit service from an arbitrary class (clazz)
     *
     * @param clazz Java interface of the retrofit service
     * @return retrofit service with defined endpoint
     */
    public <T> T createService(Class<T> clazz) {
        return createService(clazz, getHostPort());
    }


    /**
     * Creates a retrofit service from an arbitrary class (clazz)
     *
     * @param clazz    Java interface of the retrofit service
     * @param endPoint REST endpoint url
     * @return retrofit service with defined endpoint
     */
    public <T> T createService(Class<T> clazz, String endPoint) {

        OkHttpClient.Builder ocb = new OkHttpClient.Builder().
                readTimeout(60, TimeUnit.SECONDS).
                writeTimeout(60, TimeUnit.SECONDS);

        // 统一做Token验证
        if (null != mGtedxHook) {
            ocb.addInterceptor(new InterceptorToken(getGtedxHook()));
        }

        OkHttpClient okHttpClient = ocb.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endPoint) // 设置服务根节点
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())// RxJava Setting
                .addConverterFactory(GsonConverterFactory.create()) // Gson Setting
                .client(okHttpClient)
                .build();

        T service = retrofit.create(clazz);

        return service;
    }


}
