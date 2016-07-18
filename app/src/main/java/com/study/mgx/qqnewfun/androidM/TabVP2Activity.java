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
public class TabVP2Activity extends AppCompatActivity {
    // 就是页签的容器
    private TabLayout tabLayout;
    private Toolbar toolBar;

    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_viewpager2);

        toolBar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);


        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        // 可以横向滑动的，而不是固定宽度的
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);
        // TabLayout 和ViewPager集成的最简单的方式,让pagerAdapter多实现一个方法：getPagerTitle
        tabLayout.setupWithViewPager(viewPager);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 给menu填充一个布局
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    private PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return 23;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(container.getContext());
            tv.setText("" +position);
            tv.setTextSize(80);
            container.addView(tv);
            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position%3 == 0){
                return "" +position;
            }else if(position%3 == 1){
                return "P " +position;
            }else{
                return "PagerPager " +position;
            }

        }
    };
}