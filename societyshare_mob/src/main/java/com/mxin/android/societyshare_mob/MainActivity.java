package com.mxin.android.societyshare_mob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.sharesdk.framework.ShareSDK;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
        /*ShareSDK.initSDK(this, "1603c910a351f");*/
    }

    public void share(View view){


    }
}
