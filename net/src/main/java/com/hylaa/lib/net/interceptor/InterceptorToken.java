package com.hylaa.lib.net.interceptor;

import com.hylaa.lib.net.GtedxHook;
import com.hylaa.lib.net.common.NetConst;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * InterceptorSign.
 *
 * @author William Lee
 * @version v1.0.0
 * @created 2016-11-6.
 * @tel 152-5320-8570
 */
public class InterceptorToken implements Interceptor {

    private final GtedxHook mGtedxHook;

    public InterceptorToken(GtedxHook gtedxHook) {
        mGtedxHook = gtedxHook;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request.Builder headerRequestBuilder = originalRequest.newBuilder();
        headerRequestBuilder.header(NetConst.Keys.AUTHORIZATION, NetConst.Keys.BEARER + mGtedxHook.getGtedxToken());
        Request hearderRequest = headerRequestBuilder.build();
        Response response = chain.proceed(hearderRequest);
        return response;
    }

}
