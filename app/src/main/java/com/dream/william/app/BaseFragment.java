package com.dream.william.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by william on 10/20/17.
 */

public abstract class BaseFragment extends Fragment {

    protected String TAG = BaseFragment.class.getSimpleName();

    protected String getSfTag() {
        return TAG;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.w(getSfTag(), "onAttach Fragment和Activity相关联时调用。可以通过该方法获取Activity引用，还可以通过getArguments()获取参数");
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.w(getSfTag(), "onCreate Fragment被创建时调用");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.w(getSfTag(), "onCreateView 创建Fragment的布局");

        // 只有onCreateView()在重写时不用写super方法，其他都需要
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.w(getSfTag(), "onViewCreated 当Fragment完成布局解析时调用");
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.w(getSfTag(), "onActivityCreated 当Activity完成onCreate()时调用");
    }


    @Override
    public void onStart() {
        super.onStart();

        Log.w(getSfTag(), "onStart 当Fragment可见时调用");
    }


    @Override
    public void onResume() {
        super.onResume();

        Log.w(getSfTag(), "onResume 当Fragment可见且可交互时调用");
    }


    @Override
    public void onPause() {
        super.onPause();

        Log.w(getSfTag(), "onPause 当Fragment不可交互但可见时调用");
    }


    @Override
    public void onStop() {
        super.onStop();

        Log.w(getSfTag(), "onStop 当Fragment不可见时调用");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.w(getSfTag(), "onDestroyView 当Fragment的UI从视图结构中移除时调用");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.w(getSfTag(), "onDestroy 销毁Fragment时调用");
    }


    @Override
    public void onDetach() {
        super.onDetach();

        Log.w(getSfTag(), "onDetach 当Fragment和Activity解除关联时调用");
    }


}
