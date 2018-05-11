package com.mxin.android.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/***
 * webView 的使用特点
 *1，创建webView的控件
 * 2，添加权限
 * 3，加载方式
 * 4,兼容js
 */

public class MainActivity extends AppCompatActivity {

    private WebView mWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mWeb = findViewById(R.id.webview);
        //辅助web处理js的对话框，图标等
        mWeb.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                if (newProgress == 100){
                    //网页加载完成
                }else {

                    //网页加载中
                }
            }
        });
        //主要处理解析，渲染网页等浏览器做的事情
        mWeb.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                //监听网址的变化情况
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

        //如果要加载js，要进行设置
        mWeb.getSettings().setJavaScriptEnabled(true);

        //使用缓存，优先使用
        mWeb.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        //加载网页，默认会跳转到模拟器上的浏览器上加载页面
        mWeb.loadUrl("http://www.baidu.com");
    }

    //如果希望浏览器时候网页页面后退不直接推出应用，需要webview覆盖url加载

    //重写back事件


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
                if (mWeb.canGoBack()){
                    mWeb.goBack();
                    return true;
                }else {
                    System.exit(0);
                }
        }

        return super.onKeyDown(keyCode, event);
    }
}
