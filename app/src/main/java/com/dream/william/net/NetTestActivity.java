package com.dream.william.net;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;
import com.hylaa.lib.net.common.SubscriberNet;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NetTestActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar tbBar;
    private Button btnNetAction;
    private Button btnUri;
    private TextView tvNetResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_test);
        initView();
    }


    private void initView() {
        tbBar = findViewById(R.id.tb_bar);
        tbBar.setTitle("Net Request");
        setSupportActionBar(tbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnNetAction = findViewById(R.id.btn_net_action);
        btnUri = findViewById(R.id.btn_uri);
        tvNetResult = findViewById(R.id.tv_net_result);

        btnNetAction.setOnClickListener(this);
        btnUri.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_net_action:

                NetService.getInstance().getServiceInterface().getTopMovie(0, 1)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SubscriberNet<Movies>(this, true) {

                            @Override
                            protected void onGtedxNext(Movies movies) {
                                tvNetResult.setText(movies.toString());
                            }

                            @Override
                            public void onError(Throwable e) {
                                super.onError(e);
                                tvNetResult.setText(e.getMessage());
                            }
                        });

                break;
            case R.id.btn_uri:
                startActivity(new Intent(this, UriActivity.class));
                break;
        }
    }

}
