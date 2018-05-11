package com.mxin.android.eventbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

public class LoginActivity extends AppCompatActivity {

    private EditText mEt_name;
    private EditText mEt_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //进行EventBus的注册
      ///  EventBus.getDefault().register(this);

        mEt_name = findViewById(R.id.edit_name);
        mEt_pwd = findViewById(R.id.edit_pwd);
    }

    public void login(View view){
        EventBus.getDefault().post(new UserEvent(mEt_name.getText().toString(),
                mEt_pwd.getText().toString()));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //EventBus的反注册
        EventBus.getDefault().unregister(this);
    }
}
