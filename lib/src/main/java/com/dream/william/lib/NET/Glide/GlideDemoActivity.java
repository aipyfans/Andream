package com.dream.william.lib.NET.Glide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.request.RequestOptions;
import com.dream.william.lib.NET.Glide.config.GlideApp;
import com.dream.william.lib.NET.Glide.config.GlideRequestBuilder;
import com.dream.william.lib.NET.Glide.config.GlideRequestOptions;
import com.dream.william.lib.R;
import com.dream.william.lib.app.BaseActivity;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;
import static com.bumptech.glide.request.RequestOptions.fitCenterTransform;

public class GlideDemoActivity extends BaseActivity {

    private static final String ACTION_GLIDE = GlideDemoActivity.class.getName() + ".ACTION_GLIDE";

    public static final String ACTION_BASE_USE = GlideDemoActivity.class.getName() + ".ACTION_BASE_USE";
    public static final String ACTION_IN_APPLICATION = GlideDemoActivity.class.getName() + ".ACTION_IN_APPLICATION";
    public static final String ACTION_GLIDE_EXTENSION = GlideDemoActivity.class.getName() + ".ACTION_GLIDE_EXTENSION";

    public static final String ACTION_PLACE_HOLDER = GlideDemoActivity.class.getName() + ".ACTION_PLACE_HOLDER";
    public static final String ACTION_OPTIONS = GlideDemoActivity.class.getName() + ".ACTION_OPTIONS";
    public static final String ACTION_TRANSFORMATION = GlideDemoActivity.class.getName() + ".ACTION_TRANSFORMATION";

    public static final String ACTION_TARGET = GlideDemoActivity.class.getName() + ".ACTION_TARGET";


    private ImageView ivGlide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_demo);

        initView();
        initData();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    private void initView() {
        ivGlide = findViewById(R.id.iv_glide);
    }


    private void initData() {
        String action = getIntent().getStringExtra(ACTION_GLIDE);
        if (ACTION_BASE_USE.equals(action)) {
            baseUse();

        } else if (ACTION_IN_APPLICATION.equals(action)) {
            appUse();

        } else if (ACTION_GLIDE_EXTENSION.equals(action)) {

        } else if (ACTION_PLACE_HOLDER.equals(action)) {
            holderUse();

        } else if (ACTION_OPTIONS.equals(action)) {
            optionUse();

        } else if (ACTION_TRANSFORMATION.equals(action)) {
            transformationsUse();
        }
    }


    private void baseUse() {
        String imageUrl = "https://gostica.com/wp-content/uploads/2017/01/The-Universe-Responds-5-Signs-Your-Dreams-Are-Coming-True.jpg";
        Glide.with(this)
                .load(imageUrl)
                .into(ivGlide);
        //  取消加载 | 什么场景下使用？
        // Glide.with(this).clear(ivGlide);
    }


    private void appUse() {
        String imageUrl = "http://thecrackeddoor.com/Main/wp-content/uploads/2012/12/dream3.jpg";
        GlideApp.with(this)
                .load(imageUrl)
                .into(ivGlide);
    }


    private void holderUse() {
        String imageUrl = "http://qwertythoughts.com/wp-content/uploads/2017/03/dreams.jpg";
        // ① RequestOptions
        Glide.with(this).load(imageUrl).apply(GlideRequestOptions.PLACE_HOLDER_OPTIONS).into(ivGlide);

        // ② Generated API
/*        GlideApp.with(this)
                .load(imageUrl)
                .placeholder(new ColorDrawable(Color.GREEN))
                .error(new ColorDrawable(Color.RED))
                .fallback(new ColorDrawable(Color.YELLOW))
                .into(ivGlide);

        GlideApp.with(this)
                .load(null)
                .placeholder(new ColorDrawable(Color.GREEN))
                .into(ivGlide);

        GlideApp.with(this)
                .load(null)
                .error(new ColorDrawable(Color.RED))
                .into(ivGlide);

        GlideApp.with(this)
                .load(null)
                .fallback(new ColorDrawable(Color.YELLOW))
                .into(ivGlide);*/

    }

    private void optionUse() {
        String imageUrl = "http://www.artistreevt.org/assets/content_files/blog/2016/Dream.jpg";
        String thumbnailUrl = "http://qwertythoughts.com/wp-content/uploads/2017/03/dreams.jpg";

        // ① 请求选项 RequestOptions
        Glide.with(this)
                .load(imageUrl)
//                .apply(RequestOptions.centerCropTransform())
//                .apply(RequestOptions.centerInsideTransform())
//                .apply(RequestOptions.fitCenterTransform())
                .apply(RequestOptions.circleCropTransform())
                .into(ivGlide);

        // ② 请求选项 Generated API
        GlideApp.with(this)
                .load(imageUrl)
//                .centerCrop()
//                .centerInside()
//                .fitCenter()
                .circleCrop()
                .into(ivGlide);

        // ①  过渡选项 TransitionOptions
        Glide.with(this)
                .load(imageUrl)
                .transition(withCrossFade())
                .into(ivGlide);

        // ② 过渡选项 Generated API
        GlideApp.with(this)
                .load(imageUrl)
                .transition(withCrossFade(800))
                .into(ivGlide);

        // RequestBuilder
        GlideRequestBuilder.getRBB(this).load(imageUrl).into(ivGlide);

        // 缩略图 ①
        Glide.with(this)
                .load(imageUrl)
                .thumbnail(
                        Glide.with(this)
                                .load(thumbnailUrl)
                )
                .into(ivGlide);

        // 缩略图 ②
        Glide.with(this)
                .load(imageUrl)
                .thumbnail(0.2f)
                .into(ivGlide);

        // 在失败时开始新的请求
        Glide.with(this)
                .load(imageUrl)
                .error(
                        Glide.with(this)
                                .load(thumbnailUrl)
                )
                .into(ivGlide);

        // TODO 组件选项 Option

    }


    private void transformationsUse() {
        String imageUrl = "http://modifylifestyle.com/wp-content/uploads/2014/04/dare-to-dream.jpg";

        // ① 默认变换
        RequestOptions options = new RequestOptions();
        options.centerCrop();

        Glide.with(this)
                .load(imageUrl)
                .apply(options)
                .into(ivGlide);

        //② 默认变换 大多数内置的变换都有静态的 import ，这是为 API 的流畅性考虑的。例如，你可以通过静态方法应用一个 FitCenter 变换
        Glide.with(this)
                .load(imageUrl)
                .apply(fitCenterTransform())
                .into(ivGlide);

        // ③  默认变换 如果你正在使用 Generated API ，那么这些变换方法已经被内联了，所以使用起来甚至更为轻松
        GlideApp.with(this)
                .load(imageUrl)
                .fitCenter()
                .into(ivGlide);

        // ④ 多重变换
        GlideApp.with(this)
                .load(imageUrl)
                .transform(
                        new MultiTransformation(
                                new FitCenter(),
                                new CenterCrop(),
                                new CenterInside()
                        )
                )
                .into(ivGlide);

        //⑤ 多重变换 或结合使用快捷方法和 generated API：
        GlideApp.with(this)
                .load(imageUrl)
                .transforms(
                        new FitCenter(),
                        new CenterCrop(),
                        new CenterInside()
                )
                .into(ivGlide);

        // 请注意，你向 MultiTransformation 的构造器传入变换参数的顺序，决定了这些变换的应用顺序
    }


    public static void startAction(Context context, String action) {
        Intent intent = new Intent(context, GlideDemoActivity.class);
        intent.putExtra(ACTION_GLIDE, action);
        context.startActivity(intent);
    }
}
