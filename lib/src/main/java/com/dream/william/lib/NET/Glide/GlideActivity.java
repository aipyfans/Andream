package com.dream.william.lib.NET.Glide;

import android.os.Bundle;
import android.view.View;

import com.dream.william.lib.R;
import com.dream.william.lib.app.BaseActivity;

/**
 * https://muyangmin.github.io/glide-docs-cn/
 *
 * http://blog.csdn.net/column/details/15318.html
 */
public class GlideActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_glide);
        setTitle("Glide");
    }


    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_glide_base_user:
                GlideDemoActivity.startAction(this, GlideDemoActivity.ACTION_BASE_USE);
                break;

            case R.id.btn_glide_application:
                GlideDemoActivity.startAction(this, GlideDemoActivity.ACTION_IN_APPLICATION);
                break;

            case R.id.btn_glide_extension:
                GlideDemoActivity.startAction(this, GlideDemoActivity.ACTION_GLIDE_EXTENSION);
                break;

            case R.id.btn_glide_holder:
                GlideDemoActivity.startAction(this, GlideDemoActivity.ACTION_PLACE_HOLDER);
                break;

            case R.id.btn_glide_option:
                GlideDemoActivity.startAction(this, GlideDemoActivity.ACTION_OPTIONS);
                break;

            case R.id.btn_glide_transformation:
                GlideDemoActivity.startAction(this, GlideDemoActivity.ACTION_TRANSFORMATION);
                break;

            case R.id.btn_glide_target:
                GlideDemoActivity.startAction(this, GlideDemoActivity.ACTION_TARGET);
                break;
        }
    }
}
