package com.dream.william.view.widget.WebView;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

import java.util.HashMap;
import java.util.Set;


/**
 * http://www.jianshu.com/p/345f4d8a5cfa
 */
public class Web2JsActivity extends BaseActivity {

    private ViewGroup rootView;
    private WebView wvPage;
    private Toolbar tbBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web2_js);
        initView();
    }


    @Override
    protected void onResume() {
        super.onResume();
        wvPage.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        wvPage.onPause();
    }


    @Override
    public void onBackPressed() {
        if (wvPage.canGoBack()) {
            wvPage.goBack();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    protected void onDestroy() {
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
        tbBar.setTitle("WebView 与 JavaScript 的交互");

        setSupportActionBar(tbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        wvPage = findViewById(R.id.wv_page);

        WebSettings webSettings = wvPage.getSettings();

        // 设置允许和Js进行交互
        webSettings.setJavaScriptEnabled(true);

        // 设置允许JS弹窗
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        // 通过addJavascriptInterface()将Java对象映射到JS对象
        // 参数1：Javascript对象名 参数2：Java对象名
        //【Web2JsInterface类的对象实例】映射到【js的web2js】对象
        wvPage.addJavascriptInterface(new Web2JsInterface(), "web2js");


        wvPage.loadUrl("file:///android_asset/web2js.html");

        // 由于设置了弹窗检验调用结果,所以需要支持js对话框
        // WebView只是载体，内容的渲染需要使用WebViewChromeClient类去实现
        // 通过设置WebChromeClient对象处理JavaScript的对话框
        //设置响应js 的Alert()函数
        wvPage.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog.Builder b = new AlertDialog.Builder(Web2JsActivity.this);
                b.setTitle("Alert");
                b.setMessage(message);
                b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                    }
                });
                b.setCancelable(false);
                b.create().show();
                return true;
            }

        });

        // 复写WebViewClient类的shouldOverrideUrlLoading方法
        wvPage.setWebViewClient(new WebViewClient() {

                                    @Override
                                    public boolean shouldOverrideUrlLoading(WebView view, String url) {

                                        // 步骤2：根据协议的参数，判断是否是所需要的url
                                        // 一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
                                        //假定传入进来的 url = "js://webview?arg1=111&arg2=222"（同时也是约定好的需要拦截的）

                                        Uri uri = Uri.parse(url);
                                        // 如果url的协议 = 预先约定的 js 协议
                                        // 就解析往下解析参数
                                        if (uri.getScheme().equals("js")) {

                                            // 如果 authority  = 预先约定协议里的 webview，即代表都符合约定的协议
                                            // 所以拦截url,下面JS开始调用Android需要的方法
                                            if (uri.getAuthority().equals("webview")) {

                                                //  步骤3：
                                                // 执行JS所需要调用的逻辑
                                                Log.w("JS", "js调用了Native的方法");
                                                Toast.makeText(Web2JsActivity.this, "js调用了Native的方法", Toast.LENGTH_SHORT).show();

                                                // 可以在协议上带有参数并传递到Android上
                                                HashMap<String, String> params = new HashMap<>();
                                                Set<String> collection = uri.getQueryParameterNames();
                                            }

                                            return true;
                                        }
                                        return super.shouldOverrideUrlLoading(view, url);
                                    }
                                }
        );

        wvPage.setWebChromeClient(new WebChromeClient() {
                                      // 拦截输入框(原理同方式2)
                                      // 参数message:代表 prompt() 的内容（不是url）
                                      // 参数 result : 代表输入框的返回值
                                      @Override
                                      public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                                          // 根据协议的参数，判断是否是所需要的url(原理同方式2)
                                          // 一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
                                          //假定传入进来的 url = "js://prompt?arg1=111&arg2=222"（同时也是约定好的需要拦截的）

                                          Uri uri = Uri.parse(message);
                                          // 如果url的协议 = 预先约定的 js 协议
                                          // 就解析往下解析参数
                                          if (uri.getScheme().equals("js")) {

                                              // 如果 authority  = 预先约定协议里的 prompt，即代表都符合约定的协议
                                              // 所以拦截url,下面JS开始调用Android需要的方法
                                              if (uri.getAuthority().equals("prompt")) {

                                                  // 执行JS所需要调用的逻辑
                                                  Log.w("JS","js调用了Native的方法");
                                                  Toast.makeText(Web2JsActivity.this, "js调用了Native的方法", Toast.LENGTH_SHORT).show();

                                                  // 可以在协议上带有参数并传递到Android上
                                                  HashMap<String, String> params = new HashMap<>();
                                                  Set<String> collection = uri.getQueryParameterNames();

                                                  //参数result:代表消息框的返回值(输入值)
                                                  result.confirm("js调用了Android的方法成功啦");
                                              }
                                              return true;
                                          }
                                          return super.onJsPrompt(view, url, message, defaultValue, result);
                                      }

                                      // 通过alert()和confirm()拦截的原理相同，此处不作过多讲述

                                      // 拦截JS的警告框
                                      @Override
                                      public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                                          return super.onJsAlert(view, url, message, result);
                                      }

                                      // 拦截JS的确认框
                                      @Override
                                      public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                                          return super.onJsConfirm(view, url, message, result);
                                      }
                                  }
        );
    }


    public void onClick(View view) {
        int id = view.getId();
        switch (id) {

            case R.id.btn_load_url:
                wvPage.post(new Runnable() {
                    @Override
                    public void run() {
                        wvPage.loadUrl("javascript:callJS()");
                    }
                });
                break;

            // 优点：该方法比第一种方法效率更高、使用更简洁。
            // 因为该方法的执行不会使页面刷新，而第一种方法（loadUrl ）的执行则会。 Android 4.4 后才可使用
            case R.id.btn_evaluate_js:
                if (Build.VERSION.SDK_INT >= 19) {
                    wvPage.evaluateJavascript("javascript:callJS()", new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) { //此处为 js 返回的结果
                            Toast.makeText(Web2JsActivity.this, value, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                break;

        }
    }


}
