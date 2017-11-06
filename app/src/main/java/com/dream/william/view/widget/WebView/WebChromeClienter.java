package com.dream.william.view.widget.WebView;

import android.graphics.Bitmap;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * 作用：辅助 WebView 处理 Javascript 的对话框, 网站图标, 网站标题 等等。
 *
 * Created by william on 11/6/17.
 */

public class WebChromeClienter extends WebChromeClient {

    /**
     * 作用：获得网页的加载进度并显示.
     *
     * @param view
     * @param newProgress
     */
    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);

    }


    /**
     * 作用：获取Web页中的标题.
     *
     * @param view
     * @param title
     */
    @Override
    public void onReceivedTitle(WebView view, String title) {
        super.onReceivedTitle(view, title);
        // tbBar.setTitle(title);
    }


    /**
     *
     * @param view
     * @param icon
     */
    @Override
    public void onReceivedIcon(WebView view, Bitmap icon) {
        super.onReceivedIcon(view, icon);

    }


    /**
     * 作用：支持javascript的警告框.
     *
     * @param view
     * @param url
     * @param message
     * @param result
     * @return
     */
    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        // TODO Dialog or Toast
        // result.confirm();
        // result.cancel();
        return super.onJsAlert(view, url, message, result);
    }


    /**
     * 作用：支持javascript的确认框.
     *
     * @param view
     * @param url
     * @param message
     * @param result
     * @return
     */
    @Override
    public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
        // TODO Dialog or Toast

        // result.confirm();
        // result.cancel();

        // 返回布尔值：判断点击时确认还是取消
        // true表示点击了确认；false表示点击了取消；
        return super.onJsConfirm(view, url, message, result);
    }


    /**
     * 作用：支持javascript输入框 ---- 点击确认返回输入框中的值，点击取消返回 null.
     *
     * @param view
     * @param url
     * @param message
     * @param defaultValue
     * @param result
     * @return
     */
    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        // TODO Dialog or Toast

        // result.confirm("输入的值");
        // result.cancel();

        return super.onJsPrompt(view, url, message, defaultValue, result);
    }

}
