package com.study.mgx.qqnewfun.androidM;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import cn.itcast.wh.androidm.R;

/**
 * Created by Teacher on 2016/1/10.
 */
public class TabActivity extends AppCompatActivity {
    // 就是页签的容器
    private TabLayout tabLayout;
    private Toolbar toolBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        toolBar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);

        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        // 添加页签
        tabLayout.addTab(tabLayout.newTab().setText("Android").setIcon(R.drawable.heart));
        tabLayout.addTab(tabLayout.newTab().setText("UI").setIcon(R.drawable.search));
        tabLayout.addTab(tabLayout.newTab().setText("iOS").setIcon(R.drawable.msg));
        //  设置页签点击事件
        tabLayout.setOnTabSelectedListener(tabSelectedListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 给menu填充一个布局
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private TabLayout.OnTabSelectedListener tabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            Toast.makeText(TabActivity.this,"onTabSelected" +tab.getText(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            Toast.makeText(TabActivity.this,"onTabUnselected" +tab.getText(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
            Toast.makeText(TabActivity.this,"onTabReselected" +tab.getPosition(),Toast.LENGTH_SHORT).show();
        }
    };
}
