package com.dream.william.view.widget.WebView;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.dream.william.app.App;

/**
 * Created by william on 11/6/17.
 */

public class Web2JsInterface {

    /**
     * 定义JS需要调用的方法
     * 被JS调用的方法必须加入@JavascriptInterface注解
     *
     * @param msg
     */
    @JavascriptInterface
    public void hello(String msg) {
        Log.w("JS", msg);
        Toast.makeText(App.getContext(), msg, Toast.LENGTH_SHORT).show();
    }


}
