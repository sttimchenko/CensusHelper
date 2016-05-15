package com.sttimchenko.censushelper.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

public class MainViewHolder {
    protected ViewPager viewPager;
    protected TabLayout tabLayout;
    protected Toolbar toolbar;

    public MainViewHolder(ViewPager viewPager, TabLayout tabLayout, Toolbar toolbar) {
        this.viewPager = viewPager;
        this.tabLayout = tabLayout;
        this.toolbar = toolbar;
    }
}
