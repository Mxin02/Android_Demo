package com.mxin.android.indicator_advertisement;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<View> mViews = new ArrayList<>();
    private Indicator mIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDate();

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPagerAdapter());

        viewPager.setOnPageChangeListener(new MyPagerListener());
        //找到广告点
        mIndicator = findViewById(R.id.indicator);



    }

    /**初始化数据**/
    private void initDate() {

        for (int i = 0; i < 4 ;i++){

            View inflate = getLayoutInflater().inflate(R.layout.pager_item,null);
            ImageView imageView = inflate.findViewById(R.id.iv);
            imageView.setImageResource(R.mipmap.ic_launcher);
            mViews.add(inflate);

        }
    }

    class MyPagerListener implements ViewPager.OnPageChangeListener{


        //viewPager的滚动

        /***
         *
         * @param position                  位置
         * @param positionOffset            偏移量
         * @param positionOffsetPixels      偏移百分比
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            Log.e("onPageScrolled", "positionOffset<< "+positionOffset +"  positionOffsetPixels<<<" + positionOffsetPixels);
            mIndicator.setOffset(position,positionOffset);
        }
        //viewPager被选中
        @Override
        public void onPageSelected(int position) {

        }

        //viewPager滑动状态改变
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }




    class MyPagerAdapter extends PagerAdapter{


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            position %= 4;
            View view = mViews.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            position %= 4;
            View view = mViews.get(position);
            container.removeView(view);
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
