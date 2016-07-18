package com.study.mgx.qqnewfun.androidM;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.itcast.wh.androidm.R;

/**
 * Created by Teacher on 2016/1/10.
 */
public class TabVP1Activity  extends AppCompatActivity {
    // 就是页签的容器
    private TabLayout tabLayout;
    private Toolbar toolBar;

    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_viewpager1);

        toolBar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);


        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        // 添加页签
        tabLayout.addTab(tabLayout.newTab().setText(names[0]).setIcon(R.drawable.heart));
        tabLayout.addTab(tabLayout.newTab().setText(names[1]).setIcon(R.drawable.search));
        tabLayout.addTab(tabLayout.newTab().setText(names[2]).setIcon(R.drawable.msg));
        //  设置页签点击事件,进行viewp的切换
        tabLayout.setOnTabSelectedListener(tabListener);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);

        // 把viewpager的切换告诉tablayout
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    String[]  names = new String[]{"Android","UI","iOS"};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 给menu填充一个布局
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private TabLayout.OnTabSelectedListener tabListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            int position = tab.getPosition();
            viewPager.setCurrentItem(position);
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };
    private PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return names == null ? 0 :names.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(container.getContext());
            tv.setText(names[position]);
            tv.setTextSize(80);
            container.addView(tv);
            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    };
}