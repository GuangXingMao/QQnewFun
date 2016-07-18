package com.study.mgx.qqnewfun.androidM;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import cn.itcast.wh.androidm.R;


public class MyToolBarActivity extends AppCompatActivity {


    private static final int REQUEST_CODE = 1;
    private SearchView searchView;
    private Toolbar toolBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        toolBar = (Toolbar)findViewById(R.id.tool_bar);
//        可以交给Acivity处理
//        toolBar.inflateMenu(R.menu.main_menu);
//        toolBar.setOnMenuItemClickListener(this);
        setSupportActionBar(toolBar);
    }

    // 如果需要菜单，就重写此方法，并返回true
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 给menu填充一个布局
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // 点击菜单项会调用此方法
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_heart:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
            return true;
        }
        if(item.isCheckable()){
            item.setChecked(true);
        }

        return super.onOptionsItemSelected(item);
    }
    private View.OnClickListener searchListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),"搜索",Toast.LENGTH_SHORT).show();
        }
    };

}
