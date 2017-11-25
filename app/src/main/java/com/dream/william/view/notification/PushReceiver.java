package com.dream.william.view.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import com.dream.william.R;
import com.dream.william.photophase.PhaseActivity;

public class PushReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intentPush = new Intent(context, PhaseActivity.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intentPush, PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.activity_notification_custom);
        remoteViews.setTextViewText(R.id.tv_count, "2 notifications");
        remoteViews.setImageViewResource(R.id.iv_i, R.mipmap.ic_launcher_round);
        remoteViews.setImageViewResource(R.id.iv_heart, R.mipmap.ic_launcher_round);
        remoteViews.setImageViewResource(R.id.iv_u, R.mipmap.ic_launcher_round);
        remoteViews.setOnClickPendingIntent(R.id.cl_notification, pendingIntent);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);// 注意：必须设置，否则异常
        builder.setAutoCancel(true);

        Notification notification = builder.setContent(remoteViews).build();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(520, notification);
    }
}
