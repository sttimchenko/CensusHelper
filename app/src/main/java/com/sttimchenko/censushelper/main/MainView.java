package com.sttimchenko.censushelper.main;

public interface MainView {
    void setupTabs();
    void setupViewPager(PagerAdapter adapter);
    void changePagerItem(int position);
}
