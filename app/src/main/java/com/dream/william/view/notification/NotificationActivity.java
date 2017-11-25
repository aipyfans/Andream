package com.dream.william.view.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;
import com.dream.william.photophase.PhaseActivity;

import java.util.UUID;

/**
 * Android Notification通知栏开发详解
 * http://www.jcodecraeer.com/a/anzhuokaifa/developer/2014/0323/1600.html
 * <p>
 * Android Notification 官网
 * https://developer.android.com/guide/topics/ui/notifiers/notifications.html?hl=zh-cn
 * <p>
 * NotificationCompat.Builder
 * https://developer.android.com/reference/android/support/v4/app/NotificationCompat.Builder.html
 * <p>
 * NotificationManager
 * https://developer.android.com/reference/android/app/NotificationManager.html
 * <p>
 * RemoteViews
 * https://developer.android.com/reference/android/widget/RemoteViews.html
 * <p>
 * Android通知及RemoteViews整理
 * https://jestar719.github.io/2017/02/27/Android%E9%80%9A%E7%9F%A5%E5%8F%8ARemoteView%E6%95%B4%E7%90%86/
 * <p>
 * Android 开发之 Notification 详解
 * http://glgjing.github.io/blog/2015/11/18/android-kai-fa-zhi-notification-xiang-jie/
 * <p>
 * Android通知栏介绍与适配总结
 * http://iluhcm.com/2017/03/12/experience-of-adapting-to-android-notifications/
 *
 * Android通知栏介绍与适配总结
 * http://iluhcm.com/2017/03/12/experience-of-adapting-to-android-notifications/#RemoteViews适配
 *
 *Android自定义Notification并没有那么简单
 * https://www.bbsmax.com/A/WpdKgAGMdV/
 *
 * Android 通知栏Notification的整合 全面学习 （一个DEMO让你完全了解它）
 * http://blog.csdn.net/vipzjyno1/article/details/25248021
 */
public class NotificationActivity extends BaseActivity {

    private Toolbar tbBar;

    private int NID_CODE = UUID.randomUUID().hashCode();
    private int numMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        tbBar = findViewById(R.id.tb_bar);
        tbBar.setTitle("Notification");
        setSupportActionBar(tbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public void onClick(View view) {
        int id = view.getId();
        switch (id) {

            case R.id.btn_simple_notification:
                standardNotification();
                break;

            case R.id.btn_media_notification:
                mediaNotification();
                break;

            case R.id.btn_big_picture_notification:
                bigPictureNotification();
                break;

            case R.id.btn_big_text_notification:
                bigTextNotification();
                break;

            case R.id.btn_inbox_notification:
                inboxNotification();
                break;

            case R.id.btn_progress_notification:
                progressDefaultIndicatorNotification();
                progressActivityIndicatorNotification();
                break;

            case R.id.btn_float_notification:
                floatNotification();
                break;

            case R.id.btn_lock_notification:
                lockNotification();
                break;

            case R.id.btn_custom_notification:
                customNotification();
                break;

            case R.id.btn_update_notification:
                updateNotification();
                break;

            case R.id.btn_cancel_notification:
                cancelNotification();
                break;
        }

    }


    /**
     * 通用的通知.
     */
    private void standardNotification() {

        Intent resultIntent = new Intent(this, NotificationActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NotificationActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(NID_CODE, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setContentTitle("通知标题");
        builder.setContentText("通知内容");
        builder.setNumber(521);

        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);// 点击后自动取消

        builder.setShowWhen(true);// 时间
        builder.setWhen(System.currentTimeMillis());

        builder.setPriority(NotificationCompat.PRIORITY_HIGH);  // 设置通知的优先级
//        builder.setVibrate();// 震动
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(alarmSound);// 声音

        Notification notification = builder.build();
        NotificationManagerCompat.from(this).notify(NID_CODE, notification);
    }


    /**
     * 请记住，扩展通知在 Android 4.1 之前的平台上不可用。要了解如何处理针对 Android 4.1 及更早版本平台的通知，请阅读处理兼容性部分。
     * <p>
     * MediaStyle 媒体播放器样式.可以最多提供5个Action,用与后台播放媒体文件
     */
    private void mediaNotification() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("My notification")
                .setContentText("Hello World!");


        Notification notification = builder.build();
        NotificationManagerCompat.from(this).notify(NID_CODE, notification);
    }


    /**
     * 请记住，扩展通知在 Android 4.1 之前的平台上不可用。要了解如何处理针对 Android 4.1 及更早版本平台的通知，请阅读处理兼容性部分。
     * <p>
     * BigPictureStyle 大图样式.可以附加一张图片,扩展显示
     */
    private void bigPictureNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("My notification")
                .setContentText("Hello World!");

        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        Bitmap bigBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);

        // Sets a title for the Inbox in expanded layout
        bigPictureStyle.setBigContentTitle("大图展示");
        bigPictureStyle.setSummaryText("SummaryText");
        bigPictureStyle.bigPicture(bigBitmap);
        bigPictureStyle.bigLargeIcon(bigBitmap);

        // Moves the expanded layout object into the notification object.
        builder.setStyle(bigPictureStyle);

        Notification notification = builder.build();
        NotificationManagerCompat.from(this).notify(NID_CODE, notification);
    }


    /**
     * 请记住，扩展通知在 Android 4.1 之前的平台上不可用。要了解如何处理针对 Android 4.1 及更早版本平台的通知，请阅读处理兼容性部分。
     * <p>
     * BigTextStyle 多文字内容.下拉显示全部文字
     */
    private void bigTextNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("My notification")
                .setContentText("Hello World!");

        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();

        // Sets a title for the Inbox in expanded layout
        bigTextStyle.setBigContentTitle("邮件标题：");
        bigTextStyle.setSummaryText("SummaryText");

        // Moves events into the expanded layout
        StringBuffer sb = new StringBuffer("邮件内容：\n");
        for (int i = 0; i < 5; i++) {
            sb.append(i + 1 + ".静水流深\n");
        }
        bigTextStyle.bigText(sb);

        // Moves the expanded layout object into the notification object.
        builder.setStyle(bigTextStyle);

        Notification notification = builder.build();
        NotificationManagerCompat.from(this).notify(NID_CODE, notification);
    }


    /**
     * 请记住，扩展通知在 Android 4.1 之前的平台上不可用。要了解如何处理针对 Android 4.1 及更早版本平台的通知，请阅读处理兼容性部分。
     * <p>
     * InboxStyle 文字式表样式,可以以列表的形式显示最多5行的文字
     */
    private void inboxNotification() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("My notification")
                .setContentText("Hello World!");

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        // Sets a title for the Inbox in expanded layout
        inboxStyle.setBigContentTitle("邮件标题：");
        inboxStyle.setSummaryText("SummaryText");

        // Moves events into the expanded layout
        for (int i = 0; i < 5; i++) {
            inboxStyle.addLine("邮件内容" + i);
        }

        // Moves the expanded layout object into the notification object.
        builder.setStyle(inboxStyle);

        Notification notification = builder.build();
        NotificationManagerCompat.from(this).notify(NID_CODE, notification);
    }


    /**
     * 进度条通知.
     * <p>
     * 显示持续时间固定的进度指示器
     */
    private void progressDefaultIndicatorNotification() {
        final NotificationManagerCompat notificationManager = NotificationManagerCompat.from(NotificationActivity.this);

        final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("Picture Download")
                .setContentText("Download in progress")
                .setSmallIcon(R.mipmap.ic_launcher);

        final int NID = 0;

        // Start a lengthy operation in a background thread
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        int incr;
                        // Do the "lengthy" operation 20 times
                        for (incr = 0; incr <= 100; incr += 5) {

                            // Sets the progress indicator to a max value, the current completion percentage, and "determinate" state
                            mBuilder.setProgress(100, incr, false);

                            // Displays the progress bar for the first time.
                            notificationManager.notify(NID, mBuilder.build());

                            // Sleeps the thread, simulating an operation that takes time
                            try {  // Sleep for 1 seconds
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                Log.d(TAG, "sleep failure");
                            }
                        }

                        mBuilder
                                // When the loop is finished, updates the notification
                                .setContentText("Download complete")
                                // Removes the progress bar
                                .setProgress(0, 0, false);

                        notificationManager.notify(NID, mBuilder.build());
                    }
                }
                // Starts the thread by calling the run() method in its Runnable
        ).start();

    }


    /**
     * 进度条通知.
     * <p>
     * 显示持续 Activity 指示器
     */
    private void progressActivityIndicatorNotification() {
        final NotificationManagerCompat notificationManager = NotificationManagerCompat.from(NotificationActivity.this);

        final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("Picture Download")
                .setContentText("Download in progress")
                .setSmallIcon(R.mipmap.ic_launcher);

        final int NID = 1;

        // Start a lengthy operation in a background thread
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        int incr;
                        // Do the "lengthy" operation 20 times
                        for (incr = 0; incr <= 100; incr += 5) {

                            // Sets an activity indicator for an operation of indeterminate length
                            mBuilder.setProgress(0, 0, true);

                            // Issues the notification
                            notificationManager.notify(NID, mBuilder.build());

                            // Sleeps the thread, simulating an operation that takes time
                            try {  // Sleep for 1 seconds
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                Log.d(TAG, "sleep failure");
                            }
                        }

                        mBuilder
                                // When the loop is finished, updates the notification
                                .setContentText("Download complete")
                                // Removes the progress bar
                                .setProgress(0, 0, false);

                        notificationManager.notify(NID, mBuilder.build());
                    }
                }
                // Starts the thread by calling the run() method in its Runnable
        ).start();
    }


    /**
     * 对于 Android 5.0（API 级别 21），当设备处于活动状态时（即，设备未锁定且其屏幕已打开），通知可以显示在小型浮动窗口中（也称为“浮动通知”）。
     * 这些通知看上去类似于精简版的通知​​，只是浮动通知还显示操作按钮。 用户可以在不离开当前应用的情况下处理或清除浮动通知。
     * <p>
     * 可能触发浮动通知的条件示例包括：
     * <p>
     * 用户的 Activity 处于全屏模式中（应用使用 fullScreenIntent），或者
     * 通知具有较高的优先级并使用铃声或振动
     * TODO 具体用法需深入研究
     */
    private void floatNotification() {

        Intent resultIntent = new Intent(this, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, NID_CODE, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setContentTitle("通知标题");
        builder.setContentText("通知内容");

        // 设置通知的优先级
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        // 设置通知的提示音
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(alarmSound);

        // builder.setContentIntent(pendingIntent);
        // 下面这行代码,在不同的ROM不兼容,有的跳转,有的不跳
        // builder.setFullScreenIntent(pendingIntent, true);

        Notification notification = builder.build();
        NotificationManagerCompat.from(this).notify(NID_CODE, notification);
    }

    /**
     * 随着 Android 5.0（API 级别 21）的发布，通知现在还可显示在锁定屏幕上。
     * 您的应用可以使用此功能提供媒体播放控件以及其他常用操作。
     * 用户可以通过“设置”选择是否将通知显示在锁定屏幕上，并且您可以指定您应用中的通知在锁定屏幕上是否可见。
     * <p>
     * 您的应用可以控制在安全锁定屏幕上显示的通知中可见的详细级别。 调用 setVisibility() 并指定以下值之一：
     * <p>
     * VISIBILITY_PUBLIC 显示通知的完整内容。
     * VISIBILITY_SECRET 不会在锁定屏幕上显示此通知的任何部分。
     * VISIBILITY_PRIVATE 显示通知图标和内容标题等基本信息，但是隐藏通知的完整内容。
     * <p>
     * TODO 具体用法需深入研究
     */
    private void lockNotification() {

        Intent resultIntent = new Intent(this, NotificationActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NotificationActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(NID_CODE, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setContentTitle("通知标题");
        builder.setContentText("通知内容");
        builder.setContentIntent(pendingIntent);
        builder.setVisibility(Notification.VISIBILITY_PUBLIC);

        final Notification notification = builder.build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                NotificationManagerCompat.from(NotificationActivity.this).notify(NID_CODE, notification);
            }
        }).start();

    }

    /**
     * 自定义通知栏视图.
     * 自定义通知布局的可用高度取决于通知视图。普通视图布局限制为 64 dp，扩展视图布局限制为 256 dp。
     */
    private void customNotification() {
        Intent intentPush = new Intent(this, PhaseActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intentPush, PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.activity_notification_custom);
        remoteViews.setTextViewText(R.id.tv_count, "2 notifications");
        remoteViews.setImageViewResource(R.id.iv_i, R.mipmap.ic_launcher_round);
        remoteViews.setImageViewResource(R.id.iv_heart, R.mipmap.ic_launcher_round);
        remoteViews.setImageViewResource(R.id.iv_u, R.mipmap.ic_launcher_round);
        remoteViews.setOnClickPendingIntent(R.id.cl_notification, pendingIntent);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);// 注意：必须设置，否则异常
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        Notification notification = builder.setContent(remoteViews).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(520, notification);
    }


    private void updateNotification() {
        final NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        // Sets an ID for the notification, so it can be updated
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("New Message")
                .setContentText("You've received new messages.")
                .setSmallIcon(R.mipmap.ic_launcher);
        numMessages = 0;

        // Start of a loop that processes data and then notifies the user
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {

                    String text = String.format("You've received %d messages.", ++numMessages);
                    builder.setContentText(text).setNumber(numMessages);
                    // Because the ID remains unchanged, the existing notification is updated.
                    notificationManager.notify(NID_CODE, builder.build());

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    private void cancelNotification() {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.cancel(NID_CODE);
        // notificationManager.cancelAll();
    }
}
