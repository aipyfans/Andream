package com.hylaa.lib.net.interceptor;

import android.util.Log;

import com.hylaa.lib.net.common.NetConst;

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
public class InterceptorBody implements Interceptor {


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

            Log.e("monster-path", urlPath);
            Log.e("monster-method", method);

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

                            Log.e("monster-field-name", fieldName);

                            String fieldType = field.getType().getSimpleName();
                            Log.e("monster-field-type", fieldType);

                            Object value = field.get(body);//  Get the value of the attribute
                            if ("byte[]".equals(fieldType)) {
                                byte[] bytes = (byte[]) value;
                                bodyJson = new String(bytes);
                            }

                            if ("ByteString".equals(fieldType)) {
                                ByteString bsJson = (ByteString) value;
                                bodyJson = bsJson.utf8();
                            }

                            Log.e("monster-body---", bodyJson);
                            break;
                        }
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();// TODO 定义异常类型
                    throw new IllegalAccessError(e.getMessage());
                }
            }

        }

        Response response = chain.proceed(originalRequest);
        return response;
    }

}
