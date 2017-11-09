package com.dream.william.view.widget;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;
import com.dream.william.view.main.LazyPagerAdapter;

import java.util.Arrays;

/**
 * TabLayout 使用.
 * http://www.jianshu.com/p/13f334eb16ce
 */
public class TabLayoutActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {

    private String[] tabsText = {"电影", "综艺", "娱乐", "亲子", "电视剧", "教育", "金融", "法律"};
    private int[] tabsIcon = {R.mipmap.ic_menu_item1, R.mipmap.ic_menu_item2, R.mipmap.ic_menu_item3, R.mipmap.ic_menu_item4};

    private Toolbar tbBar;
    private TabLayout tlWithText, tlWithIcon, tlWithTextIcon;
    private ViewPager vpFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        initView();
    }


    private void initView() {
        tbBar = findViewById(R.id.tb_bar);
        tbBar.setTitle("TabLayout Activity");
        setSupportActionBar(tbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tlWithText = findViewById(R.id.tl_with_text);
        tlWithText.addOnTabSelectedListener(this);
        for (String tab : tabsText) {
            tlWithText.addTab(tlWithText.newTab().setText(tab));
        }

        tlWithIcon = findViewById(R.id.tl_with_icon);
        tlWithIcon.addOnTabSelectedListener(this);
        for (int icon : tabsIcon) {
            tlWithIcon.addTab(tlWithIcon.newTab().setIcon(icon));
        }

        tlWithTextIcon = findViewById(R.id.tl_with_text_icon);
        tlWithTextIcon.addOnTabSelectedListener(this);

        for (int i = 0; i < 4; i++) {
            tlWithTextIcon.addTab(tlWithTextIcon.newTab().setText(tabsText[i]).setIcon(tabsIcon[i]));
        }

        vpFragment = findViewById(R.id.vp_fragment);
        tlWithTextIcon.setupWithViewPager(vpFragment);

        LazyPagerAdapter lazyPagerAdapter = new LazyPagerAdapter(getSupportFragmentManager(), Arrays.copyOf(tabsText,4));
        vpFragment.setAdapter(lazyPagerAdapter);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Toast.makeText(this, tab.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

}
