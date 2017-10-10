package com.dream.william.view.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

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
    }


    private void initData(){
        String url = getIntent().getStringExtra(URL);
        mWvPage.loadUrl(url);
    }


    public static void startActionWv(Context context,String url){
        Intent intent = new Intent(context,WebViewActivity.class);
        intent.putExtra(URL,url);
        context.startActivity(intent);
    }

}
