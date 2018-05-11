package com.mxin.android.eventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private TextView mTv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //进行EventBus的注册
        EventBus.getDefault().register(this);

        mTv_name = findViewById(R.id.tv_name);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(UserEvent userEvent){

        mTv_name.setText("用户昵称："+userEvent.getUserName());
    }

    public void startLogin(View view){

        startActivity(new Intent(this,LoginActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //EventBus的反注册
        EventBus.getDefault().unregister(this);
    }
}
