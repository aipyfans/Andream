package com.dream.william.view.custom.hencoder.view06.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.dream.william.R;
import com.dream.william.view.custom.Utils;


public class Practice05MultiProperties extends ConstraintLayout {

    Button animateBt;
    ImageView imageView;
    boolean animated;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，同时对多个属性做动画
                if(!animated){
                    imageView.animate()
                            .translationX(Utils.dpToPixel(200))
                            .scaleX(1f)
                            .scaleY(1f)
                            .alpha(1f)
                            .rotation(360);
                }else {
                    imageView.animate()
                            .translationX(0)
                            .scaleX(0)
                            .scaleY(0)
                            .alpha(0f)
                            .rotation(0);
                }
                animated = !animated;
            }
        });
    }
}
