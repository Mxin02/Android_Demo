package com.mxin.android.tabhostfragment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {


    private Class[] fragments = new Class[]{
            MainFragment.class, ArroundFragment.class, MineFragment.class, MoreFragment.class
    } ;

    private int[] imgSelectors = new int[]{
            R.drawable.ic_home_tab_index_selector,
            R.drawable.ic_home_tab_near_selector,
            R.drawable.ic_home_tab_my_selector,
            R.drawable.ic_home_tab_more_selector
    };
    private String[] tabTitles = new String[]{"首页","周边","我的","更多"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTabHost tabHost = findViewById(R.id.tabHost);

        tabHost.setup(MainActivity.this,getSupportFragmentManager(),android.R.id.tabcontent);


        for (int i = 0; i<fragments.length;i++){
            View inflate = getLayoutInflater().inflate(R.layout.tab_item, null);
            ImageView tab_iv = inflate.findViewById(R.id.iv);
            TextView tab_tv = inflate.findViewById(R.id.tv);

            tab_iv.setImageResource(imgSelectors[i]);
            tab_tv.setText(tabTitles[i]);
            tabHost.addTab(tabHost.newTabSpec(""+ i).setIndicator(inflate),fragments[i],null);
        }

    }
}
