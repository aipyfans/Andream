package com.hylaa.lib.net.error;


import android.content.Context;
import android.text.TextUtils;

import com.hylaa.lib.R;
import com.hylaa.lib.net.common.NetConst;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Create error messages according to the exception.
 *
 * @author William Lee
 * @version v1.0.0
 * @created 2016-11-7
 * @tel 152-5320-8570
 */
public class ErrorFactory {


    private ErrorFactory() {
        //empty
    }


    /**
     * Creates a String representing an error message.
     *
     * @param context
     * @param throwable An exception used as a condition to retrieve the correct error message.
     * @return {@link String} an error message.
     */
    public static String create(Context context, Throwable throwable) {

        String message = throwable.getMessage();

        if (throwable instanceof HttpException) {
            // TODO

        } else if (throwable instanceof UnknownHostException || throwable instanceof ConnectException) {
            message = context.getString(R.string.str_net_exception);

        } else if (throwable instanceof SocketTimeoutException || throwable instanceof TimeoutException) {
            message = context.getString(R.string.str_net_time_out);
            
        }else if(throwable instanceof ApiError){
            ApiError ae = (ApiError)throwable;

            if (NetConst.HttpCode.HC_ASYNC_TICKET == ae.getCode()) {
                message = ae.getMessage();
            }

            if (NetConst.HttpCode.HC_NOT_MODIFIED == ae.getCode()) {
                message = ae.getMessage();
            }

            if (NetConst.HttpCode.HC_BAD_REQUEST == ae.getCode()) {
                message = ae.getMessage();
            }

            if (NetConst.HttpCode.HC_UNAUTHORIZED == ae.getCode()) {
                message = ae.getMessage();
            }

            if (NetConst.HttpCode.HC_FORBIDDEN == ae.getCode()) {
                message = ae.getMessage();
            }

            if (NetConst.HttpCode.HC_NOT_FOUND == ae.getCode()) {
                message = ae.getMessage();
            }

            if (NetConst.HttpCode.HC_NOT_ACCEPTABLE == ae.getCode()) {
                message = ae.getMessage();
            }

            if (NetConst.HttpCode.HC_NOT_INTERNAL_SERVER_ERROR == ae.getCode()) {
                message = ae.getMessage();
            }

            if (NetConst.HttpCode.HC_BAD_GATEWAY == ae.getCode()) {
                message = ae.getMessage();
            }

            if (NetConst.HttpCode.HC_SERVICE_UNAVAILABLE == ae.getCode()) {
                message = ae.getMessage();
            }

            if (NetConst.HttpCode.HC_SERVICE_GATEWAY_TIMEOUT == ae.getCode()) {
                message = ae.getMessage();
            }
        }

        return TextUtils.isEmpty(message) ? context.getString(R.string.str_toast_later) : message;
    }

}
