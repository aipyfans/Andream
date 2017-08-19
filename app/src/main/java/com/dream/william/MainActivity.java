package com.dream.william;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dream.william.app.BaseActivity;
import com.dream.william.photophase.PhaseActivity;
import com.dream.william.photophase.PhaseEditActivity;
import com.dream.william.photophase.PhaseShowActivity;
import com.dream.william.view.notification.NotificationActivity;
import com.dream.william.view.widget.SearchViewActivity;
import com.dream.william.view.widget.ToolBarActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onClick(View view){
        int id = view.getId();
        switch (id){

            case R.id.btn_activity:

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

            case R.id.btn_photo_phase:
                startActivity(new Intent(this, PhaseActivity.class));
                break;

            case R.id.btn_phase_edit:
                startActivity(new Intent(this, PhaseEditActivity.class));
                break;

            case R.id.btn_phase_show:
                startActivity(new Intent(this, PhaseShowActivity.class));
                break;

            case R.id.btn_tool_bar:
                startActivity(new Intent(this, ToolBarActivity.class));
                break;

            case R.id.btn_search_view:
                startActivity(new Intent(this, SearchViewActivity.class));
                break;

        }
    }


}
