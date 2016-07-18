package com.study.mgx.qqnewfun.androidM;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import cn.itcast.wh.androidm.R;

/**
 * Created by Teacher on 2016/1/10.
 */
public class CoorFABSnackActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolBar;

    private FloatingActionButton fab1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coor_fab_snack);

        toolBar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);

        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setOnClickListener(this);
    }

    // 如果需要菜单，就重写此方法，并返回true
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 给menu填充一个布局
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab1:
                // 显示SnackBar
                Snackbar.make(v, "短的", Snackbar.LENGTH_SHORT).show();
                break;
        }
    }


    ;
}