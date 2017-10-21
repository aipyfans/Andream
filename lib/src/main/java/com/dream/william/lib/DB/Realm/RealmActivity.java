package com.dream.william.lib.DB.Realm;

import android.os.Bundle;

import com.dream.william.lib.R;
import com.dream.william.lib.app.BaseActivity;

/**
 * https://github.com/realm/realm-java
 *
 * http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2017/0926/8551.html
 */
public class RealmActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);
    }
}
