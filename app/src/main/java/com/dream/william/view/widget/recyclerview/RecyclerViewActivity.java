package com.dream.william.view.widget.recyclerview;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

public class RecyclerViewActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar tbBar;
    private Button btnLv;
    private Button btnGv;
    private Button btnPbl;
    private RecyclerView rvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
    }

    private void initView() {
        tbBar = (Toolbar) findViewById(R.id.tb_bar);
        tbBar.setTitle("RecyclerViewActivity");
        setSupportActionBar(tbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnLv = (Button) findViewById(R.id.btn_lv);
        btnGv = (Button) findViewById(R.id.btn_gv);
        btnPbl = (Button) findViewById(R.id.btn_pbl);
        rvView = (RecyclerView) findViewById(R.id.rv_view);

        btnLv.setOnClickListener(this);
        btnGv.setOnClickListener(this);
        btnPbl.setOnClickListener(this);

        onClick(btnLv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_lv://这里用线性显示 类似于listview
                rvView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.btn_gv: //这里用线性宫格显示 类似于grid view
                rvView.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            case R.id.btn_pbl: // //这里用线性宫格显示 类似于瀑布流
                rvView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
                break;
        }
        rvView.setAdapter(new NormalRecyclerViewAdapter(this));
    }

}
