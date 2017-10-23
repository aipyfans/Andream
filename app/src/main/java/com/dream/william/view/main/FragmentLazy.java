package com.dream.william.view.main;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dream.william.R;


public class FragmentLazy extends Fragment {


    private static final String ARG_TITLE = FragmentLazy.class.getName() + ".title";

    private Activity mActivity;
    private View mRootView;
    private String mTitle;

    private boolean mIsInited;
    private boolean mIsPrepared;


    public FragmentLazy() {
        // Required empty public constructor
    }


    public static FragmentLazy newInstance(String title) {
        FragmentLazy fragment = new FragmentLazy();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.mActivity = (Activity) context;
        mTitle = getArguments().getString(ARG_TITLE);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_lazy, container, false);
        mIsPrepared = true;
        lazyLoad();
        return mRootView;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyLoad();
        }
    }


    private void lazyLoad() {
        if (getUserVisibleHint() && mIsPrepared && !mIsInited) {
            loadData();//异步初始化，在初始化后显示正常UI
        }
    }


    private void loadData() {
        new Thread() {
            public void run() {
                SystemClock.sleep(1000);
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (mRootView != null) {
                            View emptyView = mRootView.findViewById(R.id.tv_lazy_load);
                            emptyView.setVisibility(View.GONE);

                            TextView text = (TextView) mRootView.findViewById(R.id.tv_data);
                            text.setText(mTitle);
                            text.setVisibility(View.VISIBLE);
                        }
                        mIsInited = true;
                    }
                });

            }
        }.start();
    }


}
