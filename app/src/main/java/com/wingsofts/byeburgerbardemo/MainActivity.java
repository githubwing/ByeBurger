package com.wingsofts.byeburgerbardemo;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  RecyclerView mRecyclerView;
  ViewPager mViewPager;
  List<Fragment> fragmentList;
  BottomNavigationView mByeBurger;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initData();

    initView();
  }

  private void initView() {
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    toolbar.setTitleTextColor(Color.WHITE);
    toolbar.setTitle("Bye! Bye! Burger");
    setSupportActionBar(toolbar);
    mViewPager = (ViewPager) findViewById(R.id.viewpager);
    mByeBurger = (BottomNavigationView) findViewById(R.id.bye_burger);

    mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
      @Override public Fragment getItem(int position) {
        return fragmentList.get(position);
      }

      @Override public int getCount() {
        return fragmentList.size();
      }
    });


    mByeBurger.setOnNavigationItemSelectedListener(
        new BottomNavigationView.OnNavigationItemSelectedListener() {
          @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if(item.getTitle().equals("home")){
              mViewPager.setCurrentItem(0);
            }else if(item.getTitle().equals("search")){
              mViewPager.setCurrentItem(1);
            }else if(item.getTitle().equals("me")){
              mViewPager.setCurrentItem(2);
            }else if(item.getTitle().equals("setting")){
              mViewPager.setCurrentItem(3);
            }
            return false;
          }
        });

  }

  private void initData() {
    fragmentList = new ArrayList<>();
    fragmentList.add(HomeFragment.newInstance());

    fragmentList.add(HolderFragment.newInstance("search"));

    fragmentList.add(HolderFragment.newInstance("me"));

    fragmentList.add(HolderFragment.newInstance("setting"));
  }
}