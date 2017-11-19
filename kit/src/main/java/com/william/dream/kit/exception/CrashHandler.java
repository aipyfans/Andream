package com.william.dream.kit.exception;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

import com.william.dream.kit.app.AppManager;

import java.text.SimpleDateFormat;

/**
 * Created by william on 11/19/17.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    /**
     * 格式化时间
     */
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

    /**
     *
     */
    private Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;

    /**
     *
     */
    private static CrashHandler mCrashHandler;

    /**
     * 锁对象
     */
    private static Object lock = new Object();

    private Context mContext;


    private CrashHandler() {
        // Empty Constractor
    }


    public static CrashHandler getInstance() {
        synchronized (lock) {
            if (null == mCrashHandler) {
                synchronized (lock) {
                    if (null == mCrashHandler) {
                        mCrashHandler = new CrashHandler();
                    }
                }
            }
            return mCrashHandler;
        }
    }


    /* 初始化 */
    public void init(Context context) {
        this.mContext = context;
        Thread.setDefaultUncaughtExceptionHandler(this);
        defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    }


    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (isHandler(ex)) {
            handlerException(ex);
        } else {
            defaultUncaughtExceptionHandler.uncaughtException(thread, ex);
        }
    }

    private boolean isHandler(Throwable ex) {
        // 排序不需要捕获的情况
        if (ex == null) {
            return false;
        }

        // ...

        return true;
    }

    private void handlerException(Throwable ex) {

        new Thread(new Runnable() {

            @Override
            public void run() {

                Looper.prepare();
                Toast.makeText(mContext, "程序开小差了呢..", Toast.LENGTH_SHORT).show();
                Looper.loop();

                // 收集设备信息
                collectDeviceInfo();

                // 保存到SDCard
                saveCrashInfo2File();

                // 上传至服务器
                uploadServer();

                // 将Activity的栈清空 | 退出程序
                AppManager.getAppManager().exit(mContext);

            }

        }).start();
    }


    /**
     * 收集设备参数信息.
     *
     * 包括应用的版本号 | 版本名称
     */
    public void collectDeviceInfo() {

    }


    /**
     * 保存错误信息到文件中
     *
     * @return 返回文件名称, 便于将文件传送到服务器
     */
    private String saveCrashInfo2File() {

        return null;
    }


    /**
     * 根据服务端的要求,商议具体是上传文件还是上传文本信息.
     * 也可以应用下次启动时同步本地的异常文件.
     */
    private void uploadServer() {

    }



}

