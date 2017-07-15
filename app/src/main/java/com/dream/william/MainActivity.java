package com.dream.william;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dream.william.photophase.PhaseActivity;
import com.dream.william.photophase.PhaseEditActivity;
import com.dream.william.photophase.PhaseShowActivity;
import com.dream.william.view.notification.NotificationActivity;

public class MainActivity extends AppCompatActivity {

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

        }
    }


}
