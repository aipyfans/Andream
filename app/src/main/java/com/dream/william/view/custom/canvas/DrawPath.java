package com.dream.william.view.custom.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by william on 10/26/17.
 */

public class DrawPath extends View {

    private Paint mPaintText;
    private Paint mPaintPoint;
    private Paint mPaintLine;
    private Paint mPaintShapeFill;
    private Paint mPaintShapeStroke;
    private Paint mPaintShapeFS;


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
        mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintText.setTextSize(64);
        mPaintText.setColor(Color.RED);

        mPaintPoint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintPoint.setColor(Color.RED);
        mPaintPoint.setStrokeWidth(48);


        mPaintLine = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintLine.setColor(Color.MAGENTA);
        mPaintLine.setStyle(Paint.Style.STROKE);
        mPaintLine.setStrokeWidth(8);

        mPaintShapeFill = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintShapeFill.setColor(Color.BLUE);
        mPaintShapeFill.setStyle(Paint.Style.FILL);

        mPaintShapeStroke = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintShapeStroke.setColor(Color.GREEN);
        mPaintShapeStroke.setStyle(Paint.Style.STROKE);
        mPaintShapeStroke.setStrokeWidth(8);

        mPaintShapeFS = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintShapeFS.setColor(Color.RED);
        mPaintShapeFS.setStyle(Paint.Style.FILL_AND_STROKE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // (100,100)
        canvas.drawText("drawCircle", 100, 100, mPaintText);

        // (200,300)
        canvas.drawCircle(200, 300, 100, mPaintShapeFill);

        // (450,300)
        canvas.drawCircle(450, 300, 100, mPaintShapeStroke);

        // (700,300)
        canvas.drawCircle(700, 300, 100, mPaintShapeFS);


        // (100,500)
        canvas.drawText("drawPoint", 100, 500, mPaintText);

        // (200,600) 圆头 (ROUND)
        mPaintPoint.setStrokeCap(Paint.Cap.ROUND);
        mPaintPoint.setStrokeWidth(48);
        canvas.drawPoint(200, 600, mPaintPoint);

        // (400,600) 平头 (BUTT)
        mPaintPoint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(400, 600, mPaintPoint);

        // (600,600)  方头 (SQUARE)
        mPaintPoint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(600, 600, mPaintPoint);


        // (100,850)
        canvas.drawText("drawPoints", 100, 750, mPaintText);
        float[] points = {
                200, 850, 400, 850, 600, 850,
                200, 950, 400, 950, 600, 950,
                200, 1050, 400, 1050, 600, 1050
        };
        mPaintPoint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoints(points, 2, 8, mPaintPoint);


        // (100,1200)
        canvas.drawText("drawOval", 100, 1200, mPaintText);
        // (100,1300)
        canvas.drawOval(100, 1300, 300, 1450, mPaintShapeFill);

        RectF oval = new RectF(400, 1300, 600, 1450);
        canvas.drawOval(oval, mPaintShapeStroke);


        // (100,1600)
        canvas.drawText("drawLine", 100, 1600, mPaintText);
        canvas.drawLine(200, 1700, 600, 2000, mPaintLine);

        float[] pointsLine = {200, 1700, 600, 1700, 600, 2000, 200, 2000};
        canvas.drawLines(pointsLine, mPaintLine);


        // (100,2100)
        canvas.drawText("drawRoundRect", 100, 2100, mPaintText);
        canvas.drawRoundRect(100, 2200, 300, 2300, 20, 20, mPaintShapeFill);

        RectF roundRect = new RectF(400, 2200, 600, 2300);
        canvas.drawRoundRect(roundRect, 20, 20, mPaintShapeStroke);


        // (100,2400)
        canvas.drawText("drawArc", 100, 2400, mPaintText);
        // 绘制扇形
        canvas.drawArc(100, 2500, 700, 2900, -110, 100, true, mPaintShapeFill);
        // 绘制弧形
        canvas.drawArc(100, 2500, 700, 2900, 20, 140, false, mPaintShapeFill);
        // 画线模式
        canvas.drawArc(100, 2500, 700, 2900, 180, 60, false, mPaintShapeStroke);
    }
}
