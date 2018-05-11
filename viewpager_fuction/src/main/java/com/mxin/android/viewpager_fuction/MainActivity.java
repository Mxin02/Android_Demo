package com.mxin.android.viewpager_fuction;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.mxin.android.viewpager_fuction.adapter.MyGrideAdapter;
import com.mxin.android.viewpager_fuction.adapter.MyPagerAdapter;
import com.mxin.android.viewpager_fuction.entity.HomeIconInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<View> mViews = new ArrayList<>();
    /**定义一个图标文字的容器**/
    private List<HomeIconInfo> mPagerOneData = new ArrayList<>();
    private List<HomeIconInfo> mPagerTwoData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initGrideView();

    }


    /***
     * 初始化grideView的数据
     */
    private void initData() {

        String[] iconName = getResources().getStringArray(R.array.home_bar_labels);
        TypedArray typedArray = getResources().obtainTypedArray(R.array.home_bar_icon);

        for (int i = 0; i < iconName.length;i++){

            if (i < 8){

                mPagerOneData.add(new HomeIconInfo(iconName[i],typedArray.getResourceId(i,0)));
            }else {
                mPagerTwoData.add(new HomeIconInfo(iconName[i],typedArray.getResourceId(i,0)));
            }
        }
    }

    /**
     *初始化GrideView
     */
    private void initGrideView() {

        ViewPager viewPager = findViewById(R.id.viewPager);

        View pageOne = getLayoutInflater().inflate(R.layout.home_grideview, null);
        GridView grideView01 = pageOne.findViewById(R.id.grideView);
        grideView01.setAdapter(new MyGrideAdapter(mPagerOneData,MainActivity.this));
        grideView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        View pageTwo = getLayoutInflater().inflate(R.layout.home_grideview, null);
        GridView grideView02 = pageTwo.findViewById(R.id.grideView);
        grideView02.setAdapter(new MyGrideAdapter(mPagerTwoData,MainActivity.this));
        grideView02.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        mViews.add(pageOne);
        mViews.add(pageTwo);
        viewPager.setAdapter(new MyPagerAdapter(mViews));

    }



}
