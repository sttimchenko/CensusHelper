package com.sttimchenko.censushelper.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.sttimchenko.censushelper.R;
import com.sttimchenko.censushelper.aims.AimsFragment;
import com.sttimchenko.censushelper.map.MapsFragment;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainViewHolder holder;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        holder = new MainViewHolder(
                (ViewPager) findViewById(R.id.vp_pager),
                (TabLayout) findViewById(R.id.tl_tabs),
                (Toolbar) findViewById(R.id.toolbar)
        );

        presenter = new MainPresenterImpl(this);

        setSupportActionBar(holder.toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        }

        presenter.onCreate(this, savedInstanceState);

        initListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
        holder.viewPager.addOnPageChangeListener(onPageChangeListener);
        holder.tabLayout.setOnTabSelectedListener(onTabSelectedListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        holder.viewPager.removeOnPageChangeListener(onPageChangeListener);
        holder.tabLayout.setOnTabSelectedListener(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void setupTabs() {
        holder.tabLayout.addTab(holder.tabLayout.newTab().setIcon(R.drawable.ic_google_maps_white_24dp));
        holder.tabLayout.addTab(holder.tabLayout.newTab().setIcon(R.drawable.ic_format_list_bulleted_white_24dp));
        holder.tabLayout.addTab(holder.tabLayout.newTab().setIcon(R.drawable.ic_chart_bar_white_24dp));
    }

    @Override
    public void setupViewPager(PagerAdapter adapter) {
        adapter.addFragment(new MapsFragment());
        adapter.addFragment(new AimsFragment());

        holder.viewPager.setAdapter(adapter);
    }

    @Override
    public void changePagerItem(int position) {
        holder.viewPager.setCurrentItem(position);
    }

    private TabLayout.ViewPagerOnTabSelectedListener onTabSelectedListener;
    private TabLayout.TabLayoutOnPageChangeListener onPageChangeListener;

    private void initListeners() {

        onTabSelectedListener = new TabLayout.ViewPagerOnTabSelectedListener(holder.viewPager) {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                presenter.onTabSelected(tab);
            }
        };

        onPageChangeListener = new TabLayout.TabLayoutOnPageChangeListener(holder.tabLayout) {

            public void onPageSelected(int position) {
                presenter.onPageSelected(position);
            }
        };
    }

    public ViewPager getViewPager(){
        return holder.viewPager;
    }
}
