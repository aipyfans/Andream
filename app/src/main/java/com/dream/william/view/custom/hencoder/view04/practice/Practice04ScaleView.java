package com.dream.william.view.custom.hencoder.view04.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.dream.william.R;

public class Practice04ScaleView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice04ScaleView(Context context) {
        super(context);
    }

    public Practice04ScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04ScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }


    /**
     * Canvas.scale(float sx, float sy, float px, float py) 放缩
     * 参数里的 sx sy 是横向和纵向的放缩倍数； px py 是放缩的轴心。
     */

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bw = bitmap.getWidth();
        int bh = bitmap.getHeight();

        canvas.save();
        canvas.scale(1.3f, 1.3f, point1.x + bw / 2, point1.y + bh / 2);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        canvas.scale(0.6f, 1.6f, point2.x + bw / 2, point2.y + bh / 2);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
