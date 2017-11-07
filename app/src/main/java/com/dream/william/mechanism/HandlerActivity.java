package com.dream.william.mechanism;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.dream.william.R;
import com.dream.william.app.BaseActivity;

public class HandlerActivity extends BaseActivity {

    private Toolbar tbBar;
    private TextView tvDesc;
    private boolean isOneTwo = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        initView();
        initHandler();
    }


    private void initView() {

        tbBar = findViewById(R.id.tb_bar);
        tbBar.setTitle("Handler");

        setSupportActionBar(tbBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvDesc = findViewById(R.id.tv_desc);
    }


    private void initHandler() {

    }


    public void onClick(View view) {
        int id = view.getId();
        switch (id) {

            case R.id.btn_send_msg1:
                mThread1.start();
                break;

            case R.id.btn_send_msg2:
                mThread2.start();
                break;
        }
    }

    private Handler mHandler = new Handler() {

        //通过复写handlerMessage()从而决定如何进行更新UI操作
        @Override
        public void handleMessage(Message msg) {

            String txt = tvDesc.getText().toString();
            switch (msg.what) {
                case 1:
                    tvDesc.setText(txt + "\n" + msg.obj.toString());
                    break;
                case 2:
                    tvDesc.setText(txt + "\n" + msg.obj.toString());
                    break;
            }
        }
    };

    private Thread mThread1 = new Thread() {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Message message = Message.obtain();
            if (isOneTwo) {
                message.what = 1;
                message.obj = "William";
            } else {
                message.what = 2;
                message.obj = "Dream";
            }
            mHandler.sendMessage(message);
            isOneTwo = !isOneTwo;
        }

    };

    private Thread mThread2 = new Thread() {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    String txt = tvDesc.getText().toString();
                    tvDesc.setText(txt + "\n" + "WilliamDream");
                }
            });
        }

    };

}
