package com.dream.william.view.widget.WebView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

/**
 * WebView使用详解
 * http://www.jianshu.com/p/3c94ae673e2a
 * <p>
 * Android WebView与 JS 的交互方式
 * http://www.jianshu.com/p/345f4d8a5cfa
 *
 * Android WebView 使用漏洞
 * http://www.jianshu.com/p/3a345d27cd42
 *
 * Android WebView 的缓存机制 & 资源预加载方案
 * http://www.jianshu.com/p/5e7075f4875f
 *
 */
public class WebViewActivity extends BaseActivity {

    public static final String URL = WebViewActivity.class.getName() + "URL";

    private ViewGroup rootView;
    private Toolbar tbBar;
    private WebView wvPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_view);
        initView();
        initData();
    }


    @Override
    protected void onResume() {
        super.onResume();

        // 激活WebView为活跃状态，能正常执行网页的响应.
        wvPage.onResume();

        //恢复pauseTimers状态
        // wvPage.resumeTimers();
    }


    @Override
    protected void onPause() {
        super.onPause();

        //当页面被失去焦点被切换到后台不可见状态，需要执行onPause.
        //通过onPause动作通知内核暂停所有的动作，比如DOM的解析、plugin的执行、JavaScript执行.
        wvPage.onPause();

        //当应用程序(存在WebView)被切换到后台时，这个方法不仅仅针对当前的webview而是全局的全应用程序的WebView
        //它会暂停所有WebView的layout，parsing，JavaScriptTimer。降低CPU功耗。
        // wvPage.pauseTimers();
    }


    @Override
    protected void onDestroy() {
        //销毁WebView
        //在关闭了Activity时，如果WebView的音乐或视频，还在播放. 就必须销毁WebView.
        //但是注意：WebView调用destroy时,WebView仍绑定在Activity上.
        //这是由于自定义WebView构建时传入了该Activity的Context对象.
        //因此需要先从父容器中移除WebView,然后再销毁WebView.

        if (wvPage != null) {
            wvPage.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            wvPage.clearHistory();

            rootView.removeView(wvPage);
            wvPage.destroy();
            wvPage = null;
        }
        super.onDestroy();
    }


    private void initView() {
        rootView = findViewById(R.id.cl_root);

        tbBar = findViewById(R.id.tb_bar);
        tbBar.setTitle("不为繁华易匠心,不舍初心得始终");

        setSupportActionBar(tbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        wvPage = findViewById(R.id.wv_page);
        setupWebSettings();

//        wvPage.setWebChromeClient(new WebChromeClienter());
//        wvPage.setWebViewClient(new WebViewClienter());
    }

    private void setupWebSettings() {

//        WebSettings webSettings = wvPage.getSettings();

        // 如果访问的页面中要与JavaScript交互，则WebView必须设置支持JavaScript。
        // 若加载的 html 里有JS 在执行动画等操作，会造成资源浪费（CPU、电量）.在 onStop 和 onResume 里分别把 setJavaScriptEnabled() 给设置成 false 和 true 即可
//        webSettings.setJavaScriptEnabled(true);

        //********************************      不明白       *************************************
        // 设置自适应屏幕，两者合用
//        webSettings.setUseWideViewPort(true); //将图片调整到适合WebView的大小
//        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        //缩放操作
//        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
//        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
//        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        //***********************************************************************************


        //*********************************** 缓存模式 ***************************************
        // LOAD_CACHE_ONLY: 不使用网络，只读取本地缓存数据
        // LOAD_DEFAULT: （默认）根据 cache-control 决定是否从网络上取数据。
        // LOAD_NO_CACHE: 不使用缓存，只从网络获取数据.
        // LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。
        // ***********************************************************************************

//        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);  // 不使用缓存

//        webSettings.setDomStorageEnabled(false); // 开启/关闭 DOM storage API 功能
//        webSettings.setDatabaseEnabled(true);   // 开启 Database storage API 功能
//        webSettings.setAppCacheEnabled(true);// 开启 Application Caches 功能
//        String cacheDirPath = getFilesDir().getAbsolutePath();
//        webSettings.setAppCachePath(cacheDirPath); // 设置  Application Caches 缓存目录


        //其他细节操作
//        webSettings.setAllowFileAccess(true); // 设置可以访问文件
//        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); // 支持通过JS打开新窗口
//        webSettings.setLoadsImagesAutomatically(true); // 支持自动加载图片
//        webSettings.setDefaultTextEncodingName("utf-8");// 设置编码格式
    }


    private void initData() {
        String url = getIntent().getStringExtra(URL);
        wvPage.loadUrl("https://oa_h5.hylaa.net/login");
    }


    public static void startActionWv(Context context, String url) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(URL, url);
        context.startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        if (wvPage.canGoBack()) {
            wvPage.goBack();
        } else {
            super.onBackPressed();
        }
    }


}
