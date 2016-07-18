package com.study.mgx.qqnewfun.androidM;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import cn.itcast.wh.androidm.R;

/**
 * Created by Teacher on 2016/1/10.
 */
public class CoorAppbarActivity extends AppCompatActivity{

    private Toolbar toolBar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate_appbar);

        toolBar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);

        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        // 添加页签
        tabLayout.addTab(tabLayout.newTab().setText("Android").setIcon(R.drawable.heart));
        tabLayout.addTab(tabLayout.newTab().setText("UI").setIcon(R.drawable.search));
        tabLayout.addTab(tabLayout.newTab().setText("iOS").setIcon(R.drawable.msg));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 给menu填充一个布局
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
