package com.hylaa.lib.net.interceptor;

import android.util.Log;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * TODO.
 *
 * @author William Lee
 * @version v1.0.0
 * @created 2016-11-6.
 * @tel 152-5320-8570
 */
public class InterceptorLog implements Interceptor {

    private static final String TAG = InterceptorLog.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();

        Log.e(TAG, String.format("Url-%s Time-%.1fms", response.request().url(), (t2 - t1) / 1e6d));

        return response;
    }

}
