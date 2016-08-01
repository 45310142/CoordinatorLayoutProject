package com.advanced.huza.android_41_03_coordinatorlayoutproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huza on 2016/8/1.
 */
public class TabLayoutActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private TabLayout tablayout;

    private List<Fragment> fragments;
    private String[] titles = new String[]{"新闻", "体育", "财经", "娱乐","新闻", "体育", "财经", "娱乐"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        initToolFab();

        initView();

        initFragment();

        initTablayout();


    }


    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        //设置可以滑动
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }


    private void initFragment() {
        fragments = new ArrayList<Fragment>();
        for (int i = 0; i < titles.length; i++) {
            Fragment fragment = new TitleFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", titles[i]);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);

        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
    }


    private void initTablayout() {

        for (int i = 0; i < titles.length; i++) {
            tablayout.addTab(tablayout.newTab().setText(titles[i]));
        }

        tablayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewpager));
    }


    private void initToolFab() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v, "我是超级Toast", Snackbar.LENGTH_LONG);
                snackbar.setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(TabLayoutActivity.this, "你出来了", Toast.LENGTH_LONG).show();
                    }
                });
                snackbar.show();
            }
        });
    }

}
