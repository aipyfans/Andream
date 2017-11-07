package com.william.dream.view.Toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by william on 11/7/17.
 */

public class WDToolbar extends Toolbar {

    public WDToolbar(Context context) {
        this(context, null);
    }

    public WDToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WDToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        if (context instanceof AppCompatActivity) {
            final AppCompatActivity activity = (AppCompatActivity) context;
            activity.setSupportActionBar(this);
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            setNavigationOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });
        }


    }


}
