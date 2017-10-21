package com.dream.william.component.activity.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

public class IntentFilterActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar tbBar;
    private Button btnShowIntent;
    private Button btnHideIntent;
    private Button btnChooserIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_filter);
        initView();
    }

    private void initView() {
        tbBar = (Toolbar) findViewById(R.id.tb_bar);
        tbBar.setTitle("Intent 和 Intent 过滤器");
        btnShowIntent = (Button) findViewById(R.id.btn_show_intent);
        btnShowIntent.setOnClickListener(this);
        btnHideIntent = (Button) findViewById(R.id.btn_hide_intent);
        btnHideIntent.setOnClickListener(this);
        btnChooserIntent = (Button) findViewById(R.id.btn_chooser_intent);
        btnChooserIntent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_show_intent:
                Intent showIntent = new Intent(this, IntentFilterActivity.class);
                startActivity(showIntent);
                break;

            case R.id.btn_hide_intent:
                // Create the text message with a string
                Intent hideIntent = new Intent(Intent.ACTION_SEND);
                hideIntent.putExtra(Intent.EXTRA_TEXT, "William");
                hideIntent.setType("text/plain");

                // Verify that the intent will resolve to an activity
                if (hideIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(hideIntent);
                } else {
                    Toast.makeText(this, "没有可以处理文本的应用程序", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_chooser_intent:
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Dream");
                sendIntent.setType("text/plain");

                Intent chooserIntent = Intent.createChooser(sendIntent,"为了梦-追梦");

                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooserIntent);
                } else {
                    Toast.makeText(this, "没有可以处理文本的应用程序", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}
