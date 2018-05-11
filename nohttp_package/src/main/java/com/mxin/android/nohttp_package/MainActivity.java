package com.mxin.android.nohttp_package;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mxin.android.nohttp_package.nohttp.CallServer;
import com.mxin.android.nohttp_package.nohttp.HttpListener;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

public class MainActivity extends AppCompatActivity implements HttpListener<String> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Nohttp_Get(View view){
        String url = "http://www.baidu.com";
        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.GET);

        CallServer.getInstance().add(this,0,request,this,true,true);


    }


    @Override
    public void onSucceed(int what, Response<String> response) {
        switch (what){
            case 0:
                Toast.makeText(MainActivity.this, "" + response.get(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {

        switch (what){
            case 0:
                Toast.makeText(MainActivity.this, "" + exception, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
