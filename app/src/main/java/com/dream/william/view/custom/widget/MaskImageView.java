package com.dream.william.view.custom.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by william on 10/27/17.
 */

public class MaskImageView extends AppCompatImageView {

    public MaskImageView(Context context) {
        super(context);
    }

    public MaskImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MaskImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.parseColor("#88880000"));
//        canvas.drawRGB(100, 200, 100);
//        canvas.drawARGB(100, 100, 200, 100);
    }
}
