package com.mxin.android.toolbar_define;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("主标题");//设置主标题，需要在setSupportActionBar之前
        setSupportActionBar(toolbar);//设置支持toolbar

        toolbar.setNavigationContentDescription(R.mipmap.ic_launcher);  //设置导航栏图标
        toolbar.setLogo(R.mipmap.ic_launcher);  //设置appLOGO
        toolbar.setSubtitle("设置子标题");       //设置子标题


        toolbar.inflateMenu(R.menu.toolbar_menu);
        //设置菜单选项
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }
}
