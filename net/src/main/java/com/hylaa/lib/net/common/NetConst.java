package com.hylaa.lib.net.common;

import okhttp3.MediaType;

/**
 * Http Constant.
 *
 * @author William Lee
 * @version v1.0.0
 * @created 2016-11-6.
 * @tel 152-5320-8570
 */
public class NetConst {


    /**
     *
     */
    public static class Keys {

        public static final String DATE = "Date";

        public static final String AUTHORIZATION = "Authorization";

        public static final String X_GTEDX_INTEGRITY = "X-GTEDX-Integrity";

        public static final String BEARER = "Bearer ";

        public static final String GSIGN = "GSign ";

    }


    /**
     *
     */
    public static class Methods {

        public static final String GET = "GET";

        public static final String POST = "POST";

        public static final String HEAD = "HEAD";

        public static final String DELETE = "DELETE";

        public static final String PUT = "PUT";

        public static final String PATCH = "PATCH";

    }


    /**
     *
     */
    public static class MediaTypes {

        public static MediaType MEDIA_TYPE_PLAIN = MediaType.parse("text/plain;charset=utf-8");

        public static MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

        public static MediaType MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");
    }


    /**
     * Http respone code.
     */
    public static class HttpCode {

        /**
         * OK
         * 操作成功
         * 200
         */
        public static final int HC_OK = 200;

        /**
         * Async Ticket
         * 异步操作流程
         * 201
         */
        public static final int HC_ASYNC_TICKET = 201;

        /**
         * Not Modified
         * 资源未修改
         * 304
         */
        public static final int HC_NOT_MODIFIED = 304;

        /**
         * Bad Request
         * 错误请求
         * 400
         */
        public static final int HC_BAD_REQUEST = 400;

        /**
         * Unauthorized
         * 访问未授权
         * 401
         */
        public static final int HC_UNAUTHORIZED = 401;

        /**
         * Forbidden
         * 服务器拒绝反应
         * 403
         */
        public static final int HC_FORBIDDEN = 403;

        /**
         * Not Found
         * 资源未找到
         * 404
         */
        public static final int HC_NOT_FOUND = 404;

        /**
         * Not Acceptable
         * 内容不可接受
         * 406
         */
        public static final int HC_NOT_ACCEPTABLE = 406;

        /**
         * Internal Server Error
         * 内部服务器错误
         * 500
         */
        public static final int HC_NOT_INTERNAL_SERVER_ERROR = 500;

        /**
         * Bad Gateway
         * 无效网关
         * 502
         */
        public static final int HC_BAD_GATEWAY = 502;

        /**
         * Service Unavailable
         * 服务不可用
         * 503
         */
        public static final int HC_SERVICE_UNAVAILABLE = 503;

        /**
         * Gateway Timeout
         * 网关超时
         * 504
         */
        public static final int HC_SERVICE_GATEWAY_TIMEOUT = 504;

    }


}
