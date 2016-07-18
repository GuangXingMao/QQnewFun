package com.study.mgx.qqnewfun.androidM;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import cn.itcast.wh.androidm.R;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static final int REQUEST_CODE = 1;
    private SearchView searchView;
    private Toolbar toolBar;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolBar, 0, 0);
        drawer.setDrawerListener(toggle);

        nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }


    // 如果需要菜单，就重写此方法，并返回true
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 给menu填充一个布局
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        toggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Class klass = null;
        switch (item.getItemId()) {
            case R.id.nav_permission:
                klass = PermissionActivity.class;
                break;
            case R.id.nav_http:
                klass = HttpActivity.class;
                break;
            case R.id.nav_toolbar:
                klass = MyToolBarActivity.class;
                break;
            case R.id.nav_acionbar:
                klass = MyActionBarActivity.class;
                break;
            case R.id.nav_tab:
                klass = TabActivity.class;
                break;
            case R.id.nav_tabvp1:
                klass = TabVP1Activity.class;
                break;
            case R.id.nav_tabvp2:
                klass = TabVP2Activity.class;
                break;
            case R.id.nav_til:
                klass = TILActivity.class;
                break;
            case R.id.nav_fab_snack:
                klass = FABSnackActivity.class;
                break;
            case R.id.nav_coor_fab_snack:
                klass = CoorFABSnackActivity.class;
                break;
            case R.id.nav_coor_appbar:
                klass = CoorAppbarActivity.class;
                break;
            case R.id.nav_coor_coll:
                klass = CoorCollapsingActivity.class;
                break;
        }
        Intent intent = new Intent(this, klass);
        startActivity(intent);
        // 返回true表示处理了
        return true;
    }
}
