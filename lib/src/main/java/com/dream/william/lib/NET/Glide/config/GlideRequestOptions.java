package com.dream.william.lib.NET.Glide.config;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.dream.william.lib.R;

/**
 * Created by william on 11/3/17.
 * <p>
 * 请求选项
 * Glide中的大部分设置项都可以通过 RequestOptions 类和 apply() 方法来应用到程序中。
 * <p>
 * 使用 request options 可以实现（包括但不限于）：
 * <p>
 * 占位符(Placeholders)
 * 转换(Transformations)
 * 缓存策略(Caching Strategies)
 * 组件特有的设置项，例如编码质量，或Bitmap的解码配置等。
 */

public class GlideRequestOptions {

    private GlideRequestOptions() {

    }


    /**
     * 占位符(Placeholders)
     */
    public static final RequestOptions PLACE_HOLDER_OPTIONS = new RequestOptions()
            .placeholder(R.drawable.ic_palce_holder_green_24dp)
            .error(R.drawable.ic_error_holder_red_24dp)
            .fallback(R.drawable.ic_facllback_holder_blue_24dp);


    /**
     * 转换(Transformations)
     */
    public static final RequestOptions TRANSFORMATIONS_OPTIONS = new RequestOptions()
            .centerCrop()
            .centerInside()
            .fitCenter()
            .optionalCenterCrop()
            .optionalCenterInside()
            .optionalFitCenter()
            .optionalCircleCrop();


    /**
     * 缓存策略(Caching Strategies)
     */
    public static final RequestOptions CACHING_STRATEGIES_OPTIONS = new RequestOptions()
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.ALL);


    /**
     * 组件特有的设置项，例如编码质量，或Bitmap的解码配置等。
     */
    public static final RequestOptions SETTING_OPTIONS = new RequestOptions()
            .encodeQuality(0);


    /**
     * 全局配置
     */
    public static final RequestOptions GLOBAL_OPTIONS = new RequestOptions();

}
