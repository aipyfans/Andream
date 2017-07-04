package com.dream.william;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
        }
    }


}
