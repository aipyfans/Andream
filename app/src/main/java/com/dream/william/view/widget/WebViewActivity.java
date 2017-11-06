package com.dream.william.view.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;


public class WebViewActivity extends BaseActivity {

    public static final String URL = WebViewActivity.class.getName() + "URL";

    private Toolbar mTbBar;
    private WebView mWvPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_view);
        initView();
        initData();
    }


    private void initView() {
        mTbBar = (Toolbar) findViewById(R.id.tb_bar);
        mTbBar.setTitle("不为繁华易匠心,不舍初心得始终");

        setSupportActionBar(mTbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mWvPage = (WebView) findViewById(R.id.wv_page);
        mWvPage.setWebChromeClient(mWebChromeClient);
        mWvPage.setWebViewClient(mWebViewClient);
    }


    private void initData() {
        String url = getIntent().getStringExtra(URL);
        mWvPage.loadUrl(url);
    }


    public static void startActionWv(Context context, String url) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(URL, url);
        context.startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        if (mWvPage.canGoBack()) {
            mWvPage.goBack();
        } else {
            super.onBackPressed();
        }
    }


    WebViewClient mWebViewClient = new WebViewClient() {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith("http") || url.startsWith("https")) {
                view.loadUrl(url);
            }
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            Log.w(TAG, url);
        }
    };

    WebChromeClient mWebChromeClient = new WebChromeClient() {

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            mTbBar.setTitle(title);
        }

        @Override
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);

        }

    };

}
