package com.study.mgx.qqnewfun.androidM;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;

import cn.itcast.wh.androidm.R;

/**
 * Created by Teacher on 2016/1/10.
 */
public class TILActivity extends AppCompatActivity {


    private static final int REQUEST_CODE = 1;
    private SearchView searchView;
    private Toolbar toolBar;
    private TextInputLayout til;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_til);

        toolBar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);

        til = (TextInputLayout) findViewById(R.id.til);
        til.getEditText().addTextChangedListener(watcher);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 给menu填充一个布局
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            // 告诉用户，长度应大于等于6 小于等于10
            if(s.length()<6){
                til.getEditText().setError("长度应大于等于6");
            }else if(s.length()>10){
                til.getEditText().setError("长度应小于等于10");
            }else{
                til.getEditText().setError(null);
            }
        }
    };
}