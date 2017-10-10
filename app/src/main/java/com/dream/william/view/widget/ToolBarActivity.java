package com.dream.william.view.widget;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

/**
 *
 * http://yuweiguocn.github.io/using-the-app-toolbar/
 * http://www.jianshu.com/p/7b5c99e1cfa3
 *
 */
public class ToolBarActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener{


    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar)findViewById(R.id.tb_bar);
        mToolbar.setTitle("Toolbar");
        mToolbar.setSubtitle("SubToolbar");
        mToolbar.setLogo(R.mipmap.ic_launcher_round);

        setSupportActionBar(mToolbar);
        //设置是否添加显示NavigationIcon.如果要用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // mToolbar.setNavigationIcon(R.mipmap.ic_launcher_round);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mToolbar.setOnMenuItemClickListener(this);
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tool_bar, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, "Search !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_notify:
                Toast.makeText(this, "Notify !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "Settings !", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
