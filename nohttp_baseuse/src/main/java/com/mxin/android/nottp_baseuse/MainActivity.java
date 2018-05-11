package com.mxin.android.nottp_baseuse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;

    /***
     *  1.如果是mac,可以安装jsonOnlineView
     *  2.如果是windows,postman,google的浏览器chrome的插件
     */

    private String postUrl = "https://api.bmob.cn/1/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTv = findViewById(R.id.tv);

    }

    public void btn_get(View view){
        //----------------可以封装
        String url = "http://www.baidu.com";

        //1.创建一个队列
        //----------------可以封装
        RequestQueue queue = NoHttp.newRequestQueue();

        //3.创建消息请求
        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.GET);

        //2.利用队列去添加消息

        /***
         * what : 请求的标识
         * request：请求
         * response：请求的回调监听
         */

        /**请求可以并发,统一处理响应结果**/
        queue.add(0, request, new OnResponseListener<String>() {
            //请求一开始的回调，对话框的加载
            @Override
            public void onStart(int what) {

            }
            //请求成功的回调
            @Override
            public void onSucceed(int what, Response<String> response) {
                //设置相应的结果
                mTv.setText(response.get());

            }
            //请求失败的回调
            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {

            }
            //网络请求完成
            @Override
            public void onFinish(int what) {

            }
        });
    }

    public void btn_post(View view){
        RequestQueue queue = NoHttp.newRequestQueue();

        Request<String> request = NoHttp.createStringRequest(postUrl, RequestMethod.POST);

        //添加请求的字段
        request.addHeader("X-Bmob-REST-API-Key","2bfebfad889df974a01ab7867d411f75");
        request.addHeader("X-Bmob-Application-Id","cae7c5400719de3e04d708f5c82d94e8");
        request.addHeader("Content-Type","application/json");

        request.setDefineRequestBodyForJson("{\"username\" : \"1234567890\",\"password\" : \"654321\"}");

        queue.add(1, request, new OnResponseListener<String>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                mTv.setText(response.get());
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {

            }

            @Override
            public void onFinish(int what) {

            }
        });
    }
}
