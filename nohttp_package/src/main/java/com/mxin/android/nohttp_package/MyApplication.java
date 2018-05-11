package com.mxin.android.nohttp_package;

import android.app.Application;

import com.yolanda.nohttp.NoHttp;

/**
 * Created by Mxin on 2018/3/26.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NoHttp.initialize(this);
    }
}
