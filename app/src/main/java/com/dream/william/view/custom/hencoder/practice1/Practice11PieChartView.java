package com.dream.william.view.custom.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        RectF rectF1 = new RectF(100, 100, 500, 500);

        paint.setColor(Color.GREEN);
        canvas.drawArc(rectF1, 0, 20, true, paint);

        paint.setColor(Color.RED);
        canvas.drawArc(rectF1, 20, 40, true, paint);

        paint.setColor(Color.BLUE);
        canvas.drawArc(rectF1, 60, 30, true, paint);
    }
}
