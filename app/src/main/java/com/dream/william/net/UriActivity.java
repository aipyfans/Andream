package com.dream.william.net;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

import java.util.List;

/**
 * Uri详解之——Uri结构与代码提取.
 * <p/>
 * http://blog.csdn.net/harvic880925/article/details/44679239
 * http://www.cnblogs.com/fsjohnhuang/p/4280369.html
 */
public class UriActivity extends BaseActivity {

    String url = "http://www.java2s.com:8080/your_pa_th/fileName.htm?name=william&age=32&sex=man#harvic";

    private Toolbar tbBar;
    private TextView tvUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uri);
        initView();
        setupUri();
    }


    private void initView() {
        tbBar = findViewById(R.id.tb_bar);
        tbBar.setTitle("Net Request");
        setSupportActionBar(tbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvUri = findViewById(R.id.tv_uri);
    }


    private void setupUri() {

        SpannableStringBuilder ssb = new SpannableStringBuilder(url);

        Uri uri = Uri.parse(url);

        String scheme = uri.getScheme();
        ssb.append("\n").append("scheme");
        ssb.append("\n").append(scheme);
        setBgColor(ssb, "scheme",false);

        String schemeSpecificPart = uri.getSchemeSpecificPart();
        ssb.append("\n").append("schemeSpecificPart");
        ssb.append("\n").append(schemeSpecificPart);
        setBgColor(ssb, "schemeSpecificPart",false);


        String authority = uri.getAuthority();
        ssb.append("\n").append("authority");
        ssb.append("\n").append(authority);
        setBgColor(ssb,  "authority",false);

        String host = uri.getHost();
        ssb.append("\n").append("host");
        ssb.append("\n").append(host);
        setBgColor(ssb, "host",false);

        String port = String.valueOf(uri.getPort());
        ssb.append("\n").append("port");
        ssb.append("\n").append(port);
        setBgColor(ssb, "port",false);

        String path = uri.getPath();
        ssb.append("\n").append("path");
        ssb.append("\n").append(path);
        setBgColor(ssb, "path",true);

        List<String> paths = uri.getPathSegments();
        ssb.append("\n").append("paths");
        for (String pt : paths) {
            ssb.append("\n").append(pt);
        }
        setBgColor(ssb, "paths",false);


        String query = uri.getQuery();
        ssb.append("\n").append("query");
        ssb.append("\n").append(query);
        setBgColor(ssb, "query",false);

        String name = uri.getQueryParameter("name");
        ssb.append("\n").append("name=").append(name);
        setBgColor(ssb, "name",true);

        String age = uri.getQueryParameter("age");
        ssb.append("\n").append("age=").append(age);
        setBgColor(ssb, "age",true);

        String sex = uri.getQueryParameter("sex");
        ssb.append("\n").append("sex=").append(sex);
        setBgColor(ssb, "sex",true);

        String fragment = uri.getFragment();
        ssb.append("\n").append("fragment");
        ssb.append("\n").append(fragment);
        setBgColor(ssb, "fragment",false);

        String allUri = uri.toString();
        ssb.append("\n").append("Uri.toString()");
        ssb.append("\n").append(allUri);
        setBgColor(ssb, "Uri.toString()",false);

        tvUri.setText(ssb);
    }

    private void setBgColor(SpannableStringBuilder ssb, String txt, boolean isLast) {
        int start;
        if(isLast){
            start = ssb.toString().lastIndexOf(txt);
        }else {
            start = ssb.toString().indexOf(txt);
        }
        int end = start + txt.length();

        BackgroundColorSpan bgColorSpan = new BackgroundColorSpan(Color.parseColor("#009ad6"));
        ssb.setSpan(bgColorSpan, start, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
    }


}
