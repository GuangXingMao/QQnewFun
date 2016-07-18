package com.study.mgx.qqnewfun.androidM;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import cn.itcast.wh.androidm.R;

/**
 * Created by Teacher on 2016/1/10.
 */
public class FABSnackActivity  extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolBar;
    private FloatingActionButton fab4;

    private FloatingActionButton fab5;
    private FloatingActionButton fab1;
    private FloatingActionButton fab2;
    private FloatingActionButton fab6;
    private FloatingActionButton fab3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_snack);

        toolBar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);

        fab1 = (FloatingActionButton)findViewById(R.id.fab1);
        fab1.setOnClickListener(this);
        fab2 = (FloatingActionButton)findViewById(R.id.fab2);
        fab2.setOnClickListener(this);
        fab3 = (FloatingActionButton)findViewById(R.id.fab3);
        fab3.setOnClickListener(this);
        fab4 = (FloatingActionButton)findViewById(R.id.fab4);
        fab4.setOnClickListener(this);
        fab5 = (FloatingActionButton)findViewById(R.id.fab5);
        fab5.setOnClickListener(this);
        fab6 = (FloatingActionButton) findViewById(R.id.fab6);
        fab6.setOnClickListener(this);

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
        switch (v.getId()){
            case R.id.fab1:
                // 显示SnackBar
                Snackbar.make(v,"短的",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.fab2:
                // 显示SnackBar
                Snackbar.make(v,"长的",Snackbar.LENGTH_LONG).show();
                break;
            case R.id.fab3:
                // 显示SnackBar
                Snackbar.make(v,"无限的",Snackbar.LENGTH_INDEFINITE).show();
                break;
            case R.id.fab4:
                // 显示SnackBar,添加显示和隐藏的监听
                Snackbar.make(v,"有监听的",Snackbar.LENGTH_LONG)
                        .setCallback(callback)
                        .show();
                break;
            case R.id.fab5:
                // 显示SnackBar
                Snackbar.make(v,"点击右侧有惊喜",Snackbar.LENGTH_INDEFINITE)
                        .setAction("确认删除",acionOcl)
                        .show();
                break;
            case R.id.fab6:
                Toast.makeText(this,"onclick",Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private Snackbar.Callback callback = new Snackbar.Callback() {
        @Override
        public void onDismissed(Snackbar snackbar, int event) {
            Log.d("Callback" ,"onDismissed");

        }

        @Override
        public void onShown(Snackbar snackbar) {
            Log.d("Callback", "onShown");
        }
    };

    private View.OnClickListener acionOcl = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),"已经删除啦",Toast.LENGTH_SHORT).show();
        }
    };
            ;
}