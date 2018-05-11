package com.mxin.android.welcomesplash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //用sp来存储isFirst的状态
                SharedPreferences sp = getPreferences(MODE_PRIVATE);
                boolean isFirst = sp.getBoolean("isFirst",true);

                Intent intent = new Intent();

                if (isFirst){
                    //将isFirst改掉
                    sp.edit().putBoolean("isFirst",false);
                    //如果用户第一次启动应用
                    intent.setClass(SplashActivity.this,GuideActivity.class);
                }else {

                    intent.setClass(SplashActivity.this,MainActivity.class);
                }
                startActivity(intent);
                //可以设置界面之间的切换动画
                //overridePendingTransition();
                finish();
            }
        },3000);
    }
}
