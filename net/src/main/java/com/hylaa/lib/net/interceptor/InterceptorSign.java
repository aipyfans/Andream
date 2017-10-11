package com.hylaa.lib.net.interceptor;

import android.text.TextUtils;
import android.util.Log;

import com.hylaa.lib.net.GtedxHook;
import com.hylaa.lib.net.common.NetConst;
import com.hylaa.lib.net.common.NetUtil;

import java.io.IOException;
import java.lang.reflect.Field;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.ByteString;

/**
 * InterceptorSign.
 *
 * @author William Lee
 * @version v1.0.0
 * @created 2016-11-6.
 * @tel 152-5320-8570
 */
public class InterceptorSign implements Interceptor {


    private GtedxHook mGtedxHook;

    public InterceptorSign(GtedxHook gtedxHook) {
        mGtedxHook = gtedxHook;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request originalRequest = chain.request();
        String method = originalRequest.method();

        HttpUrl httpUrl = originalRequest.url();
        String urlPath = httpUrl.url().getPath();

        String bodyJson = null;

        /*if (NetConst.Methods.PUT.equalsIgnoreCase(method)) {
            throw new RuntimeException("No definition [PUT] of request mode,Please contact William Lee tel-[+86-152-5320-8570]");
        }

        if (NetConst.Methods.DELETE.equalsIgnoreCase(method)) {
            throw new RuntimeException("No definition [DELETE] of request mode,Please contact William Lee tel-[+86-152-5320-8570]");
        }

        if (NetConst.Methods.HEAD.equalsIgnoreCase(method)) {
            throw new RuntimeException("No definition [HEAD] of request mode,Please contact William Lee tel-[+86-152-5320-8570]");
        }

        if (NetConst.Methods.PATCH.equalsIgnoreCase(method)) {
            throw new RuntimeException("No definition [PATCH] of request mode,Please contact William Lee tel-[+86-152-5320-8570]");
        }

        if (NetConst.Methods.GET.equalsIgnoreCase(method)) {
            bodyJson = "{}";
        }*/

        if (NetConst.Methods.POST.equalsIgnoreCase(method)) {

            Log.e("sign-path", urlPath);
            Log.e("sign-method", method);

            RequestBody body = originalRequest.body();

            if (body instanceof FormBody) {
                throw new RuntimeException("No definition [FormBody] of processing,Please contact William Lee tel-[+86-152-5320-8570]");

            } else if (body instanceof MultipartBody) {
//                throw new RuntimeException("No definition [MultipartBody] of processing,Please contact William Lee tel-[+86-152-5320-8570]");

            } else {
                Class bodyReflect = body.getClass();
                Field[] fs = bodyReflect.getDeclaredFields();

                try {
                    for (int i = 0; i < fs.length; i++) {
                        Field field = fs[i];
                        field.setAccessible(true); //设置些属性是可以访问的

                        String fieldName = field.getName();// 获得属性的名称

                        if (fieldName.endsWith("content")) {

                            Log.e("sign-field-name", fieldName);

                            String fieldType = field.getType().getSimpleName();
                            Log.e("sign-field-type", fieldType);

                            Object value = field.get(body);//  Get the value of the attribute
                            if ("byte[]".equals(fieldType)) {
                                byte[] bytes = (byte[]) value;
                                bodyJson = new String(bytes);
                            }

                            if ("ByteString".equals(fieldType)) {
                                ByteString bsJson = (ByteString) value;
                                bodyJson = bsJson.utf8();
                            }

                            Log.e("sign-value---", bodyJson);
                            break;
                        }
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();// TODO 定义异常类型
                    throw new IllegalAccessError(e.getMessage());
                }
            }

        }

        /*X-GTEDX-Integrity: gsign  MD5( OAuthAccessToken \n MD5( Method \n URI \n ReqBody ) )*/
        /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        Request.Builder headerRequestBuilder = originalRequest.newBuilder();

        // Case 1 : Request body is empty
        if (TextUtils.isEmpty(bodyJson)) {
            bodyJson = "{}";
        }

        // Case 2 : Request body is not empty
        if (!TextUtils.isEmpty(bodyJson)) {
            String utcDate = NetUtil.getCurrentUTCDate();
            String md5Inner = NetUtil.getMD5(method + "\n" + urlPath + "\n" + bodyJson);
            String md5Outer = NetUtil.getMD5(mGtedxHook.getGtedxToken() + "\n" /*+ utcDate + "\n" */ + md5Inner); // TODO 此处1234通过内存或配置文件读取token

            headerRequestBuilder
                    .header(NetConst.Keys.DATE, utcDate)
                    .header(NetConst.Keys.AUTHORIZATION, NetConst.Keys.BEARER + mGtedxHook.getGtedxToken()) // TODO 此处1234通过内存或配置文件读取token
                    .header(NetConst.Keys.X_GTEDX_INTEGRITY, NetConst.Keys.GSIGN + md5Outer)
//                    .header("X-Authenticated-Userid","15000522222@1"); // TODO 记得移除 学生
                    .header("X-Authenticated-Userid", mGtedxHook.getGtedxToken()); // TODO 记得移除 老师15000500000@1
        }
        /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

        Request hearderRequest = headerRequestBuilder.build();
        Response response = chain.proceed(hearderRequest);
        return response;
    }

}
