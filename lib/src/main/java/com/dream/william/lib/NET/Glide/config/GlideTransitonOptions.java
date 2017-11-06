package com.dream.william.lib.NET.Glide.config;

import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Created by william on 11/3/17.
 * <p>
 * TransitionOptions 用于决定你的加载完成时会发生什么。
 * <p>
 * 使用 TransitionOption 可以应用以下变换：
 * <p>
 * View淡入
 * 与占位符交叉淡入
 * 或者什么都不发生
 * 如果不使用变换，你的图像将会“跳入”其显示位置，直接替换掉之前的图像。
 * 为了避免这种突然的改变，你可以淡入view，或者让多个Drawable交叉淡入，而这些都需要使用TransitionOptions完成。
 * 不同于RequestOptions，TransitionOptions是特定资源类型独有的，你能使用的变换取决于你让Glide加载哪种类型的资源。
 * <p>
 * 这样的结果是，假如你请求加载一个 Bitmap ，你需要使用 BitmapTransitionOptions ，而不是 DrawableTransitionOptions 。
 * 同样，当你请求加载 Bitmap 时，你只需要做简单的淡入，而不需要做复杂的交叉淡入。
 */
public class GlideTransitonOptions {

    private GlideTransitonOptions() {

    }

    public static final DrawableTransitionOptions DTO = new DrawableTransitionOptions().crossFade();

    public static final BitmapTransitionOptions BTO = new BitmapTransitionOptions().crossFade(800);

    public static final GenericTransitionOptions GTO = new GenericTransitionOptions();

}
