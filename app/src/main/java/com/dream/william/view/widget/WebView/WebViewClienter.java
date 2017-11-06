package com.dream.william.view.widget.WebView;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * 作用：处理各种通知 & 请求事件.
 * <p>
 * Created by william on 11/6/17.
 */
public class WebViewClienter extends WebViewClient {

    /**
     * 作用：打开网页时不调用系统浏览器， 而是在本WebView中显示；在网页上的所有加载都经过这个方法,这个函数我们可以做很多操作.
     *
     * @param view
     * @param url
     * @return
     */
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }


    /**
     * 作用：开始载入页面调用的，我们可以设定一个loading的页面，告诉用户程序在等待网络响应.
     *
     * @param view
     * @param url
     * @param favicon
     */
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        // 设定加载开始的操作
    }


    /**
     * 作用：在页面加载结束时调用。我们可以关闭loading 条，切换程序动作.
     *
     * @param view
     * @param url
     */
    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        // 设定加载结束的操作
    }


    /**
     * 作用：在加载页面资源时会调用，每一个资源（比如图片）的加载都会调用一次.
     *
     * @param view
     * @param url
     */
    @Override
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        // 设定加载资源的操作
    }


    /**
     * 作用：加载页面的服务器出现错误时（如404）调用.
     * <p>
     * App里面使用 WebView 控件的时候遇到了诸如404这类的错误的时候，
     * 若也显示浏览器里面的那种错误提示页面就显得很丑陋了，
     * 那么这个时候我们的app就需要加载一个本地的错误提示页面，
     * 即 WebView 如何加载一个本地的页面
     *
     * @param view
     * @param request
     * @param error
     */
    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        //步骤1：写一个 html 文件（error_handle.html），用于出错时展示给用户看的提示页面
        //步骤2：将该 html 文件放置到代码根目录的assets文件夹下
        //步骤3：复写 WebViewClient 的 onReceivedError 方法
        //该方法传回了错误码，根据错误类型可以进行不同的错误分类处理
    }


    /**
     * 作用：处理https请求
     * WebView默认是不处理 https 请求的，页面显示空白，需要进行如下设置：
     *
     * @param view
     * @param handler
     * @param error
     */
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        super.onReceivedSslError(view, handler, error);
        handler.proceed();    // 表示等待证书响应
        // handler.cancel();      // 表示挂起连接，为默认方式
        // handler.handleMessage(null);    //可做其他处理
    }

}
