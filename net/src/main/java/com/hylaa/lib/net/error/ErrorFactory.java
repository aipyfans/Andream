package com.hylaa.lib.net.error;


import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.hylaa.lib.HylaaLib;
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
     * @param throwable An exception used as a condition to retrieve the correct error message.
     * @return {@link String} an error message.
     */
    public static NetError create(Throwable throwable) {
        Context context = HylaaLib.getInstance().getContext();

        int code = -1;
        String message = throwable.getMessage();

        if (throwable instanceof HttpException) {
            HttpException he = (HttpException) throwable;

            if (NetConst.HttpCode.HC_ASYNC_TICKET == he.code()) {
                code = he.code();
                message = he.message(); // 转变成友好的提示语言【国际化】或者根据错误码进行重试
//                message =context.getString(R.string.str_net_exception);
            }

            if (NetConst.HttpCode.HC_NOT_MODIFIED == he.code()) {
                code = he.code();
                message = he.message();// 转变成友好的提示语言
            }

            if (NetConst.HttpCode.HC_BAD_REQUEST == he.code()) {
                code = he.code();
                message = he.message();// 转变成友好的提示语言
            }

            if (NetConst.HttpCode.HC_UNAUTHORIZED == he.code()) {
                code = he.code();
                message = he.message();// 转变成友好的提示语言
            }

            if (NetConst.HttpCode.HC_FORBIDDEN == he.code()) {
                code = he.code();
                message = he.message();// 转变成友好的提示语言
            }

            if (NetConst.HttpCode.HC_NOT_FOUND == he.code()) {
                code = he.code();
                message = he.message();// 转变成友好的提示语言
            }

            if (NetConst.HttpCode.HC_NOT_ACCEPTABLE == he.code()) {
                code = he.code();
                message = he.message();// 转变成友好的提示语言
            }

            if (NetConst.HttpCode.HC_NOT_INTERNAL_SERVER_ERROR == he.code()) {
                code = he.code();
                message = he.message();// 转变成友好的提示语言
            }

            if (NetConst.HttpCode.HC_BAD_GATEWAY == he.code()) {
                code = he.code();
                message = he.message();// 转变成友好的提示语言
            }

            if (NetConst.HttpCode.HC_SERVICE_UNAVAILABLE == he.code()) {
                code = he.code();
                message = he.message();// 转变成友好的提示语言
            }

            if (NetConst.HttpCode.HC_SERVICE_GATEWAY_TIMEOUT == he.code()) {
                code = he.code();
                message = he.message();// 转变成友好的提示语言
            }

        } else if (throwable instanceof UnknownHostException || throwable instanceof ConnectException) {
            code = NetError.ERR_NET_EXCEPTION;
            message = context.getString(R.string.str_net_exception);

        } else if (throwable instanceof SocketTimeoutException || throwable instanceof TimeoutException) {
            code = NetError.ERR_NET_TIME_OUT;
            message = context.getString(R.string.str_net_time_out);

        }

        message = TextUtils.isEmpty(message) ? context.getString(R.string.str_toast_later) : message;
        return new NetError(code, message);
    }

}
