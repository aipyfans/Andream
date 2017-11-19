package com.william.dream.view.WebView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * Created by william on 11/18/17.
 * <p>
 * 默认带有进度条.
 */
public class WDWebView extends WebView implements View.OnClickListener {

    private WDProgressBar mWDProgressBar;
    private TextView mTvReload;

    private WebChromeClient mWebChromeClient;
    private WebViewClient mWebViewClient;

    private Context mContext;
    private boolean isContinue = false;


    public WDWebView(Context context) {
        this(context, null);
    }

    public WDWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WDWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        int dp2 = dp2px(context, 2);
        mWDProgressBar = new WDProgressBar(context);
        mWDProgressBar.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, dp2, 0, 0));
        mWDProgressBar.setMax(100);
        mWDProgressBar.setDefaultHeight(dp2);
        addView(mWDProgressBar);

        mTvReload = new TextView(context);
        mTvReload.setBackgroundColor(Color.WHITE);
        mTvReload.setGravity(Gravity.CENTER);
        mTvReload.setText("轻触屏幕重新加载");
        mTvReload.setOnClickListener(this);
        mTvReload.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 0, 0));
        mTvReload.setVisibility(INVISIBLE);
        addView(mTvReload);


        WebSettings webSettings = getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(false);

        super.setWebChromeClient(new WebChromeClienter());
        super.setWebViewClient(new WebViewClienter());
    }


    @Override
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        mWebChromeClient = webChromeClient;
    }


    @Override
    public void setWebViewClient(WebViewClient webViewClient) {
        mWebViewClient = webViewClient;
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        LayoutParams lp = (LayoutParams) mWDProgressBar.getLayoutParams();
        lp.x = l;
        lp.y = t;
        mWDProgressBar.setLayoutParams(lp);
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    public void onClick(View v) {
        v.setVisibility(View.INVISIBLE);
        WDWebView.this.reload();
    }

    /**
     *
     */
    public class WebChromeClienter extends android.webkit.WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (null != mWebChromeClient) {
                mWebChromeClient.onProgressChanged(view, newProgress);
            }
            updateProcessBarState(newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            if (null != mWebChromeClient) {
                mWebChromeClient.onReceivedTitle(view, title);
            }
        }

        @Override
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);
            if (null != mWebChromeClient) {
                mWebChromeClient.onReceivedIcon(view, icon);
            }
        }

        @Override
        public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
            super.onReceivedTouchIconUrl(view, url, precomposed);
            if (null != mWebChromeClient) {
                mWebChromeClient.onReceivedTouchIconUrl(view, url, precomposed);
            }
        }

        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            super.onShowCustomView(view, callback);
            if (null != mWebChromeClient) {
                mWebChromeClient.onShowCustomView(view, callback);
            }
        }

        @Override
        public void onShowCustomView(View view, int requestedOrientation, CustomViewCallback callback) {
            super.onShowCustomView(view, requestedOrientation, callback);
            if (null != mWebChromeClient) {
                mWebChromeClient.onShowCustomView(view, requestedOrientation, callback);
            }
        }

        @Override
        public void onHideCustomView() {
            super.onHideCustomView();
            if (null != mWebChromeClient) {
                mWebChromeClient.onHideCustomView();
            }
        }

        @Override
        public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {

            if (null != mWebChromeClient) {
                return mWebChromeClient.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
            }
            return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
        }

        @Override
        public void onRequestFocus(WebView view) {
            super.onRequestFocus(view);
            if (null != mWebChromeClient) {
                mWebChromeClient.onRequestFocus(view);
            }
        }

        @Override
        public void onCloseWindow(WebView window) {
            super.onCloseWindow(window);
            if (null != mWebChromeClient) {
                mWebChromeClient.onCloseWindow(window);
            }
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            if (null != mWebChromeClient) {
                return mWebChromeClient.onJsAlert(view, url, message, result);
            }
            return super.onJsAlert(view, url, message, result);
        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            if (null != mWebChromeClient) {
                return mWebChromeClient.onJsConfirm(view, url, message, result);
            }
            return super.onJsConfirm(view, url, message, result);
        }

        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            if (null != mWebChromeClient) {
                return mWebChromeClient.onJsPrompt(view, url, message, defaultValue, result);
            }
            return super.onJsPrompt(view, url, message, defaultValue, result);
        }

        @Override
        public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
            if (null != mWebChromeClient) {
                return mWebChromeClient.onJsBeforeUnload(view, url, message, result);
            }
            return super.onJsBeforeUnload(view, url, message, result);
        }

        @Override
        public void onExceededDatabaseQuota(String url, String databaseIdentifier, long quota, long estimatedDatabaseSize, long totalQuota, WebStorage.QuotaUpdater quotaUpdater) {
            super.onExceededDatabaseQuota(url, databaseIdentifier, quota, estimatedDatabaseSize, totalQuota, quotaUpdater);

            if (null != mWebChromeClient) {
                mWebChromeClient.onExceededDatabaseQuota(url, databaseIdentifier, quota, estimatedDatabaseSize, totalQuota, quotaUpdater);
            }
        }

        @Override
        public void onReachedMaxAppCacheSize(long requiredStorage, long quota, WebStorage.QuotaUpdater quotaUpdater) {
            super.onReachedMaxAppCacheSize(requiredStorage, quota, quotaUpdater);
            if (null != mWebChromeClient) {
                mWebChromeClient.onReachedMaxAppCacheSize(requiredStorage, quota, quotaUpdater);
            }
        }

        @Override
        public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
            super.onGeolocationPermissionsShowPrompt(origin, callback);
            if (null != mWebChromeClient) {
                mWebChromeClient.onGeolocationPermissionsShowPrompt(origin, callback);
            }
        }

        @Override
        public void onGeolocationPermissionsHidePrompt() {
            super.onGeolocationPermissionsHidePrompt();
            if (null != mWebChromeClient) {
                mWebChromeClient.onGeolocationPermissionsHidePrompt();
            }
        }

        @RequiresApi(21)
        @Override
        public void onPermissionRequest(PermissionRequest request) {
            super.onPermissionRequest(request);
            if (null != mWebChromeClient) {
                mWebChromeClient.onPermissionRequest(request);
            }
        }

        @RequiresApi(21)
        @Override
        public void onPermissionRequestCanceled(PermissionRequest request) {
            super.onPermissionRequestCanceled(request);
            if (null != mWebChromeClient) {
                mWebChromeClient.onPermissionRequestCanceled(request);
            }
        }

        @Override
        public boolean onJsTimeout() {
            if (null != mWebChromeClient) {
                return mWebChromeClient.onJsTimeout();
            }
            return super.onJsTimeout();
        }

        @Override
        public void onConsoleMessage(String message, int lineNumber, String sourceID) {
            super.onConsoleMessage(message, lineNumber, sourceID);
            if (null != mWebChromeClient) {
                mWebChromeClient.onConsoleMessage(message, lineNumber, sourceID);
            }
        }

        @Override
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (null != mWebChromeClient) {
                return mWebChromeClient.onConsoleMessage(consoleMessage);
            }
            return super.onConsoleMessage(consoleMessage);
        }

        @Override
        public Bitmap getDefaultVideoPoster() {
            if (null != mWebChromeClient) {
                return mWebChromeClient.getDefaultVideoPoster();
            }
            return super.getDefaultVideoPoster();
        }

        @Override
        public View getVideoLoadingProgressView() {
            if (null != mWebChromeClient) {
                return mWebChromeClient.getVideoLoadingProgressView();
            }
            return super.getVideoLoadingProgressView();
        }

        @Override
        public void getVisitedHistory(ValueCallback<String[]> callback) {
            super.getVisitedHistory(callback);
            if (null != mWebChromeClient) {
                mWebChromeClient.getVisitedHistory(callback);
            }
        }

        @RequiresApi(21)
        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            if (null != mWebChromeClient) {
                return mWebChromeClient.onShowFileChooser(webView, filePathCallback, fileChooserParams);
            }
            return super.onShowFileChooser(webView, filePathCallback, fileChooserParams);
        }
    }


    private void updateProcessBarState(int newProgress) {
        //如果没有网络直接跳出方法
        if (!isNetworkAvailable(mContext)) {
            return;
        }

        //如果进度条隐藏则让它显示
        if (View.INVISIBLE == mWDProgressBar.getVisibility()) {
            mWDProgressBar.setVisibility(View.VISIBLE);
        }

        //大于80的进度的时候,放慢速度加载,否则交给自己加载
        if (newProgress >= 80) {
            //拦截webView自己的处理方式
            if (isContinue) {
                return;
            }
            mWDProgressBar.setCurProgress(100, 3000, new WDProgressBar.OnEndListener() {
                @Override
                public void onEnd() {
                    finishOperation(true);
                    isContinue = false;
                }
            });

            isContinue = true;
        } else {
            mWDProgressBar.setNormalProgress(newProgress);
        }
    }

    /**
     * 结束进行的操作
     */
    private void finishOperation(boolean flag) {
        //最后加载设置100进度
        mWDProgressBar.setNormalProgress(100);
        //显示网络异常布局
        mTvReload.setVisibility(flag ? View.INVISIBLE : View.VISIBLE);
        hideProgressWithAnim();
    }

    /**
     * 错误的时候进行的操作
     */
    private void errorOperation() {
        if (View.INVISIBLE == mWDProgressBar.getVisibility()) {
            mWDProgressBar.setVisibility(View.VISIBLE);
        }
        //3.5s 加载 0->80 进度的加载 为了实现,特意调节长了事件
        mWDProgressBar.setCurProgress(80, 3500, new WDProgressBar.OnEndListener() {
            @Override
            public void onEnd() {
                //3.5s 加载 80->100 进度的加载
                mWDProgressBar.setCurProgress(100, 3500, new WDProgressBar.OnEndListener() {
                    @Override
                    public void onEnd() {
                        finishOperation(false);
                    }
                });
            }
        });
    }

    /**
     * 隐藏加载对话框
     */
    private void hideProgressWithAnim() {
        AnimationSet animation = getDismissAnim(mContext);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mWDProgressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        mWDProgressBar.startAnimation(animation);
    }

    /**
     * 获取消失的动画
     *
     * @param context
     * @return
     */
    private AnimationSet getDismissAnim(Context context) {
        AnimationSet dismiss = new AnimationSet(context, null);
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.0f);
        alpha.setDuration(1000);
        dismiss.addAnimation(alpha);
        return dismiss;
    }


    /**
     *
     */
    public class WebViewClienter extends android.webkit.WebViewClient {


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (null != mWebViewClient) {
                return mWebViewClient.shouldOverrideUrlLoading(view, url);
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

        @RequiresApi(24)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (null != mWebViewClient) {
                return mWebViewClient.shouldOverrideUrlLoading(view, request);
            }
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            if (null != mWebViewClient) {
                mWebViewClient.onPageStarted(view, url, favicon);
            }
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (null != mWebViewClient) {
                mWebViewClient.onPageFinished(view, url);
            }
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            if (null != mWebViewClient) {
                mWebViewClient.onLoadResource(view, url);
            }
        }

        @RequiresApi(23)
        @Override
        public void onPageCommitVisible(WebView view, String url) {
            super.onPageCommitVisible(view, url);
            if (null != mWebViewClient) {
                mWebViewClient.onPageCommitVisible(view, url);
            }
        }

        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            if (null != mWebViewClient) {
                return mWebViewClient.shouldInterceptRequest(view, url);
            }
            return super.shouldInterceptRequest(view, url);
        }

        @RequiresApi(21)
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            if (null != mWebViewClient) {
                return mWebViewClient.shouldInterceptRequest(view, request);
            }
            return super.shouldInterceptRequest(view, request);
        }

        @Override
        public void onTooManyRedirects(WebView view, Message cancelMsg, Message continueMsg) {
            super.onTooManyRedirects(view, cancelMsg, continueMsg);
            if (null != mWebViewClient) {
                mWebViewClient.onTooManyRedirects(view, cancelMsg, continueMsg);
            }
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            if (null != mWebViewClient) {
                mWebViewClient.onReceivedError(view, errorCode, description, failingUrl);
            }
            errorOperation();
        }

        @RequiresApi(23)
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            if (null != mWebViewClient) {
                mWebViewClient.onReceivedError(view, request, error);
            }
             errorOperation();
        }

        @RequiresApi(23)
        @Override
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);
            if (null != mWebViewClient) {
                mWebViewClient.onReceivedHttpError(view, request, errorResponse);
            }
        }

        @Override
        public void onFormResubmission(WebView view, Message dontResend, Message resend) {
            super.onFormResubmission(view, dontResend, resend);
            if (null != mWebViewClient) {
                mWebViewClient.onFormResubmission(view, dontResend, resend);
            }
        }

        @Override
        public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
            super.doUpdateVisitedHistory(view, url, isReload);
            if (null != mWebViewClient) {
                mWebViewClient.doUpdateVisitedHistory(view, url, isReload);
            }
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
            if (null != mWebViewClient) {
                mWebViewClient.onReceivedSslError(view, handler, error);
            }
            handler.proceed();
        }

        @RequiresApi(21)
        @Override
        public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
            super.onReceivedClientCertRequest(view, request);
            if (null != mWebViewClient) {
                mWebViewClient.onReceivedClientCertRequest(view, request);
            }
        }

        @Override
        public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
            super.onReceivedHttpAuthRequest(view, handler, host, realm);
            if (null != mWebViewClient) {
                mWebViewClient.onReceivedHttpAuthRequest(view, handler, host, realm);
            }
        }

        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            if (null != mWebViewClient) {
                return mWebViewClient.shouldOverrideKeyEvent(view, event);
            }
            return super.shouldOverrideKeyEvent(view, event);
        }

        @Override
        public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
            super.onUnhandledKeyEvent(view, event);
            if (null != mWebViewClient) {
                mWebViewClient.onUnhandledKeyEvent(view, event);
            }
        }

        @Override
        public void onScaleChanged(WebView view, float oldScale, float newScale) {
            super.onScaleChanged(view, oldScale, newScale);
            if (null != mWebViewClient) {
                mWebViewClient.onScaleChanged(view, oldScale, newScale);
            }
        }

        @Override
        public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
            super.onReceivedLoginRequest(view, realm, account, args);
            if (null != mWebViewClient) {
                mWebViewClient.onReceivedLoginRequest(view, realm, account, args);
            }
        }

        @RequiresApi(26)
        @Override
        public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
            if (null != mWebViewClient) {
                return mWebViewClient.onRenderProcessGone(view, detail);
            }
            return super.onRenderProcessGone(view, detail);
        }
    }

    /**
     * dp转px
     */
    private int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, context.getResources().getDisplayMetrics());
    }

    /**
     * @param context
     * @return
     */
    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            @SuppressLint("MissingPermission") NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }
}
