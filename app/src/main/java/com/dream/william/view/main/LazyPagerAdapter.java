package com.dream.william.view.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class LazyPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabs;

    public LazyPagerAdapter(FragmentManager fm, String[] tabs) {
        super(fm);
        mTabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentLazy.newInstance(mTabs[position]);
    }

    @Override
    public int getCount() {
        return mTabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs[position];
    }
}
