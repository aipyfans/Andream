package com.dream.william.view.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

public class MainBottomActivity extends BaseActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemReselectedListener {

    private Toolbar tbBar;
    private ViewPager vpFragment;
    private BottomNavigationView bnvNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bottom);
        initView();
    }


    private void initView() {
        tbBar = (Toolbar) findViewById(R.id.tb_bar);
        tbBar.setTitle("Bottom UI Architecture");

        setSupportActionBar(tbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String[] tabs = getResources().getStringArray(R.array.main_menu);
        LazyPagerAdapter lazyPagerAdapter = new LazyPagerAdapter(getSupportFragmentManager(),tabs);

        vpFragment = (ViewPager) findViewById(R.id.vp_fragment);
        vpFragment.setAdapter(lazyPagerAdapter);
        vpFragment.setOffscreenPageLimit(3);

        bnvNavigation = (BottomNavigationView) findViewById(R.id.bnv_nav);
        bnvNavigation.setOnNavigationItemSelectedListener(this);
        bnvNavigation.setOnNavigationItemReselectedListener(this);

    }


    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

}
