package com.dream.william.view.custom.hencoder.view01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(2);
        paint.setColor(Color.WHITE);

        canvas.drawLine(100,100,100,600,paint);
        canvas.drawLine(100,600,900,600,paint);

        paint.setColor(Color.GREEN);

        Rect rect1 = new Rect(110,580,210,600);
        canvas.drawRect(rect1,paint);

        Rect rect2 = new Rect(220,550,320,600);
        canvas.drawRect(rect2,paint);

        Rect rect3 = new Rect(330,500,430,600);
        canvas.drawRect(rect3,paint);

        Rect rect4 = new Rect(440,400,540,600);
        canvas.drawRect(rect4,paint);

        Rect rect5 = new Rect(550,350,650,600);
        canvas.drawRect(rect5,paint);

        Rect rect6 = new Rect(660,310,760,600);
        canvas.drawRect(rect6,paint);

        Rect rect7 = new Rect(770,521,870,600);
        canvas.drawRect(rect7,paint);




    }
}
