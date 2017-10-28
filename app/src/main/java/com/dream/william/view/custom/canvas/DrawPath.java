package com.dream.william.view.custom.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by william on 10/26/17.
 */

public class DrawPath extends View {

    private Paint mPaint;
    private Path mPath = new Path(); // 初始化 Path 对象


    public DrawPath(Context context) {
        this(context, null);
    }


    public DrawPath(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public DrawPath(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(64);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // (100,100)
//        canvas.drawText("Canvas-drawPath", 100, 100, mPaint);

        // 绘制心形
//        mPath.addArc(200, 200, 400, 400, -225, 225);
//        mPath.arcTo(400, 200, 600, 400, -180, 225, false);
//        mPath.lineTo(400, 542);


        // (100,200)
        canvas.drawText("Path-addXxx() ", 100, 200, mPaint);
        mPath.addCircle(200, 400, 100, Path.Direction.CW);
        canvas.drawPath(mPath, mPaint);


        // (100,600)
        canvas.drawText("Path-xxxTo()", 100, 600, mPaint);
        mPath.moveTo(100, 700);
        mPath.lineTo(200, 700);
        mPath.rLineTo(-100, 100);
        mPath.rLineTo(100, 0);


        mPath.moveTo(100, 900);
        mPath.lineTo(200, 1000);
        mPath.arcTo(200, 1000, 400, 1200, -90, 90, true); // 强制移动到弧形起点（无痕迹）
        mPath.addArc(200, 1000, 400, 1200, -90, 90);// 上面这个方法的简化版

        RectF rectArc = new RectF(200, 1000, 400, 1200);
        mPath.addArc(rectArc, -90, 90);// 上面这个方法的重载
        canvas.drawPath(mPath, mPaint);

        canvas.drawText("Path-close()", 100, 1200, mPaint);
        mPath.moveTo(100,1250);
        mPath.lineTo(200,1250);
        mPath.lineTo(150,1300);
        mPath.close();
        canvas.drawPath(mPath,mPaint);

    }
}
