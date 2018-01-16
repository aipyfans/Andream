package com.dream.william.component.content;

import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

import java.util.Calendar;

/**
 * https://developer.android.com/guide/topics/providers/calendar-provider.html?hl=zh-cn#overview
 */
public class CpCalendarActivity extends BaseActivity {

    private Toolbar tbBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp_calendar);
        initView();
    }

    private void initView() {
        tbBar = findViewById(R.id.tb_bar);
        tbBar.setTitle("Calendar Provider");

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
            case R.id.btn_insert:
                insertEvent();
                break;
            case R.id.btn_edit:
                editEvent();
                break;
            case R.id.btn_query:
                queryEvent();
                break;
        }
    }


    private void insertEvent() {
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2018, 0, 16, 14, 28);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2018, 0, 16, 14, 30);
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                .putExtra(CalendarContract.Events.TITLE, "新公司")
                .putExtra(CalendarContract.Events.DESCRIPTION, "今晚聚餐")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "普陀区")
                .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                .putExtra(Intent.EXTRA_EMAIL, "william.lee@gtedx.com,wendy@gtedx.com");
        startActivity(intent);
    }


    private void editEvent() {
        long eventID = 208;
        Uri uri = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, eventID);
        Intent intent = new Intent(Intent.ACTION_EDIT).setData(uri).putExtra(CalendarContract.Events.TITLE, "My New Title");
        startActivity(intent);
    }

    private void queryEvent() {
        // A date-time specified in milliseconds since the epoch.
        long startMillis = System.currentTimeMillis();
        Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
        builder.appendPath("time");
        ContentUris.appendId(builder, startMillis);
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(builder.build());
        startActivity(intent);

//        long eventID = 208;
//        Uri uri = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, eventID);
//        Intent intent = new Intent(Intent.ACTION_VIEW).setData(uri);
//        startActivity(intent);

    }

}
