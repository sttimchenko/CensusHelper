package com.sttimchenko.censushelper.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

public class MainPresenterImpl implements MainPresenter {
    private MainView view;
    private AppCompatActivity activity;

    public MainPresenterImpl(MainView view) {
        this.view = view;
    }

    @Override
    public void onCreate(AppCompatActivity activity, Bundle savedInstanceState) {
        this.activity = activity;

        view.setupTabs();
        view.setupViewPager(new PagerAdapter(activity.getSupportFragmentManager()));
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        view.changePagerItem(tab.getPosition());
    }

    @Override
    public void onPageSelected(int position) {

    }
}
