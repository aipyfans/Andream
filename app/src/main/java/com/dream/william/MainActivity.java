package com.dream.william;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dream.william.app.BaseActivity;
import com.dream.william.component.activity.fragment.FragmentTestActivity;
import com.dream.william.component.activity.intent.IntentFilterActivity;
import com.dream.william.component.activity.lifecycle.ActivityOne;
import com.dream.william.mechanism.MechanismActivity;
import com.dream.william.net.NetTestActivity;
import com.dream.william.view.MainViewActivity;
import com.dream.william.view.notification.NotificationActivity;

public class MainActivity extends BaseActivity {


    private Toolbar mTbBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTbBar = findViewById(R.id.tb_bar);
        mTbBar.setNavigationIcon(R.mipmap.ic_launcher_round);
        setSupportActionBar(mTbBar);
    }


    public void onClick(View view) {
        int id = view.getId();
        switch (id) {

            case R.id.btn_mechanism:
                startActivity(new Intent(this, MechanismActivity.class));
                break;

            case R.id.btn_intent_filter:
                startActivity(new Intent(this, IntentFilterActivity.class));
                break;

            case R.id.btn_activity:
                startActivity(new Intent(this, ActivityOne.class));
                break;

            case R.id.btn_fragment:
                startActivity(new Intent(this, FragmentTestActivity.class));
                break;

            case R.id.btn_service:

                break;

            case R.id.btn_broadcast_receive:

                break;

            case R.id.btn_content_provider:

                break;

            case R.id.btn_notification:
                startActivity(new Intent(this, NotificationActivity.class));
                break;

            /*case R.id.btn_photo_phase:
                startActivity(new Intent(this, PhaseActivity.class));
                break;

            case R.id.btn_phase_edit:
                startActivity(new Intent(this, PhaseEditActivity.class));
                break;

            case R.id.btn_phase_show:
                startActivity(new Intent(this, PhaseShowActivity.class));
                break;*/

            case R.id.btn_views:
                startActivity(new Intent(this, MainViewActivity.class));
                break;

            case R.id.btn_net_test:
                startActivity(new Intent(this, NetTestActivity.class));
                break;

        }
    }


}
