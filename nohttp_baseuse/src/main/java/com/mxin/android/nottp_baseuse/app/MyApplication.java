package com.mxin.android.nottp_baseuse.app;

import android.app.Application;

import com.yolanda.nohttp.NoHttp;



public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化NoHttp
        NoHttp.initialize(this);
    }
}
