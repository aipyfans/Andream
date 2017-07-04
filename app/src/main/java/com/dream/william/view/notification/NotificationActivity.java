package com.dream.william.view.notification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dream.william.R;

/**
 * https://developer.android.com/guide/topics/ui/notifiers/notifications.html?hl=zh-cn
 */
public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        setTitle("Notification");
    }


}
