package com.dream.william.lib.NET.Glide.config;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;

/**
 * Created by william on 11/3/17.
 * <p>
 * RequestBuilder 是Glide中请求的骨架，负责携带请求的url和你的设置项来开始一个新的加载过程。
 * <p>
 * 使用 RequestBuilder 可以指定：
 * <p>
 * 你想加载的资源类型(Bitmap, Drawable, 或其他)
 * 你要加载的资源地址(url/model)
 * 你想最终加载到的View
 * 任何你想应用的（一个或多个）RequestOption 对象
 * 任何你想应用的（一个或多个）TransitionOption 对象
 * 任何你想加载的缩略图 thumbnail()
 * 你可以通过调用 Glide.with() 来构造一个 RequestBuilder 对象：
 * <p>
 * RequestBuilder<Drawable> requestBuilder = Glide.with(fragment);
 */
public class GlideRequestBuilder {

    private GlideRequestBuilder() {

    }

    public static RequestBuilder<Drawable> getRBD(Activity activity) {

        RequestBuilder<Drawable> requestBuilder = Glide.with(activity).asDrawable();
        requestBuilder.apply(GlideRequestOptions.PLACE_HOLDER_OPTIONS);
        requestBuilder.transition(GlideTransitonOptions.DTO);

//        requestBuilder.apply(GlideRequestOptions.TRANSFORMATIONS_OPTIONS);
//        requestBuilder.apply(GlideRequestOptions.CACHING_STRATEGIES_OPTIONS);
//        requestBuilder.apply(GlideRequestOptions.SETTING_OPTIONS);

        return requestBuilder;
    }

    public static RequestBuilder<Bitmap> getRBB(Activity activity) {

        RequestBuilder<Bitmap> requestBuilder = Glide.with(activity).asBitmap();
        requestBuilder.apply(GlideRequestOptions.PLACE_HOLDER_OPTIONS);
        requestBuilder.transition(GlideTransitonOptions.BTO);

//        requestBuilder.apply(GlideRequestOptions.TRANSFORMATIONS_OPTIONS);
//        requestBuilder.apply(GlideRequestOptions.CACHING_STRATEGIES_OPTIONS);
//        requestBuilder.apply(GlideRequestOptions.SETTING_OPTIONS);

        return requestBuilder;
    }

}
