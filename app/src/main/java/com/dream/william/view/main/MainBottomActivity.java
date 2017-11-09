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
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemReselectedListener,ViewPager.OnPageChangeListener {

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
        tbBar =  findViewById(R.id.tb_bar);
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
        LazyPagerAdapter lazyPagerAdapter = new LazyPagerAdapter(getSupportFragmentManager(), tabs);

        vpFragment =  findViewById(R.id.vp_fragment);
        vpFragment.setAdapter(lazyPagerAdapter);
        vpFragment.setOffscreenPageLimit(3);
        vpFragment.addOnPageChangeListener(this);

        bnvNavigation =  findViewById(R.id.bnv_nav);
        bnvNavigation.setOnNavigationItemSelectedListener(this);
        bnvNavigation.setOnNavigationItemReselectedListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                bnvNavigation.setSelectedItemId(R.id.item1);
                break;
            case 1:
                bnvNavigation.setSelectedItemId(R.id.item2);
                break;
            case 2:
                bnvNavigation.setSelectedItemId(R.id.item3);
                break;
            case 3:
                bnvNavigation.setSelectedItemId(R.id.item4);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item1:
                vpFragment.setCurrentItem(0);
                break;
            case R.id.item2:
                vpFragment.setCurrentItem(1);
                break;
            case R.id.item3:
                vpFragment.setCurrentItem(2);
                break;
            case R.id.item4:
                vpFragment.setCurrentItem(3);
                break;
        }
        return true;
    }


    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {

    }

}
