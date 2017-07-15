package com.dream.william.view.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.RemoteViews;

import com.dream.william.R;
import com.dream.william.photophase.PhaseActivity;

/**
 * https://developer.android.com/guide/topics/ui/notifiers/notifications.html?hl=zh-cn
 *
 * http://glgjing.github.io/blog/2015/11/18/android-kai-fa-zhi-notification-xiang-jie/
 *
 * https://www.bbsmax.com/A/WpdKgAGMdV/
 */
public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        setTitle("Notification");
    }


//    public void onClick(View view){
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//
//        // 设置通知的基本信息：icon、标题、内容
//        builder.setSmallIcon(R.mipmap.ic_launcher_round);
//        builder.setContentTitle("My notification");
//        builder.setContentText("When I was young, I listen to the radio. Waiting for my faverate songs");
//
//        // 设置通知的点击行为：这里启动一个 Activity
//        Intent intent = new Intent(this, PhaseActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        builder.setContentIntent(pendingIntent);
//
//        // 发送通知 id 需要在应用内唯一
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(520, builder.build());
//    }

    public void onClick(View view){
        Intent intent = new Intent(this, PhaseActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteViews remoteViews = new RemoteViews(this.getPackageName(), R.layout.activity_notification_custom);
        remoteViews.setTextViewText(R.id.tv_count, "2 notifications");
        remoteViews.setImageViewResource(R.id.iv_i, R.mipmap.ic_launcher_round);
        remoteViews.setImageViewResource(R.id.iv_heart, R.mipmap.ic_launcher_round);
        remoteViews.setImageViewResource(R.id.iv_u, R.mipmap.ic_launcher_round);
        remoteViews.setOnClickPendingIntent(R.id.cl_notification, pendingIntent);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);// 注意：必须设置，否则异常

        Notification notification = builder.setContent(remoteViews).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(520, notification);
    }

}
