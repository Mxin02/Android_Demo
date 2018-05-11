package com.mxin.android.adbanner;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends FragmentActivity {

    //图片资源
    private  int[] imgResID = new int[]{R.drawable.banner01,R.drawable.banner02,R.drawable.banner03};
    private ViewPager mViewPager;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.viewPager);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        autoScroll();
    }

    //广告条自动滚动
    private void autoScroll() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //获取当前的页面下标
                int currentItem = mViewPager.getCurrentItem();
                mViewPager.setCurrentItem(currentItem+1);
                mHandler.postDelayed(this,2000);
            }
        },2000);

    }


    class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //返回fragment视图
        @Override
        public Fragment getItem(int position) {

            //定义一个模值，确保循环的是广告图片
            position %= imgResID.length;

            BannerFragment bannerFragment = new BannerFragment();
            bannerFragment.setImage(imgResID[position]);
            return bannerFragment;
        }

        @Override
        public int getCount() {
            return 10000;
        }
    }
}
