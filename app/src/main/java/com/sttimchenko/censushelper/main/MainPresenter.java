package com.sttimchenko.censushelper.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

public interface MainPresenter {
    void onCreate(AppCompatActivity activity, Bundle savedInstanceState);
    void onDestroy();
    void onTabSelected(TabLayout.Tab tab);
    void onPageSelected(int position);
}
