package com.dream.william.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;
import com.dream.william.view.custom.CustomViewActivity;
import com.dream.william.view.main.MainUIActivity;
import com.dream.william.view.widget.RecyclerView.RecyclerViewActivity;
import com.dream.william.view.widget.ToolBarActivity;
import com.dream.william.view.widget.WebView.Web2JsActivity;
import com.dream.william.view.widget.WebView.WebViewActivity;

public class MainViewActivity extends BaseActivity {


    private Toolbar mTbBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_view);
        initView();
    }

    private void initView() {
        mTbBar =  findViewById(R.id.tb_bar);
        mTbBar.setTitle("Views");

        setSupportActionBar(mTbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public void onClick(View view) {
        int id = view.getId();
        switch (id) {

            case R.id.btn_ui:
                startActivity(new Intent(this, MainUIActivity.class));
                break;

            case R.id.btn_tool_bar:
                startActivity(new Intent(this, ToolBarActivity.class));
                break;

            case R.id.btn_web_view:
                WebViewActivity.startActionWv(this,"https://www.baidu.com");
                break;

            case R.id.btn_web_js:
                startActivity(new Intent(this, Web2JsActivity.class));
                break;

            case R.id.btn_search_view:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;

            case R.id.btn_custom_view:
                startActivity(new Intent(this, CustomViewActivity.class));
                break;



        }
    }


}
