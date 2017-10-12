package com.hylaa.lib.net;


import com.hylaa.lib.net.interceptor.InterceptorToken;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServiceFactory {

    /**
     * Creates a retrofit service from an arbitrary class (clazz)
     *
     * @param clazz    Java interface of the retrofit service
     * @param endPoint REST endpoint url
     * @return retrofit service with defined endpoint
     */
    public <T> T createService(Class<T> clazz, String endPoint, String token) {

        OkHttpClient.Builder ocb = new OkHttpClient.Builder().
                readTimeout(60, TimeUnit.SECONDS).
                writeTimeout(60, TimeUnit.SECONDS);

        // 统一做Token验证
        if (null != token) {
            ocb.addInterceptor(new InterceptorToken(token));
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
