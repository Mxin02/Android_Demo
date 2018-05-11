package com.mxin.android.nohttp_package.nohttp;

import android.content.Context;
import android.content.DialogInterface;

import com.mxin.android.nohttp_package.widget.WaitDialog;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

/**
 * Created by Mxin on 2018/3/26.
 */

public class HttpResponseListener<T> implements OnResponseListener<T> {

    private HttpListener<T> mListener ;
    private WaitDialog mWaitDialog;
    private boolean isLoading;
    private Request<?> mRequest;


    public HttpResponseListener(Context context, Request<?> request,HttpListener<T> listener, boolean canCancle, boolean isLoading) {
        this.mRequest = request;
        mWaitDialog =  new WaitDialog(context);
        mWaitDialog.setCancelable(canCancle);
        mWaitDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                mWaitDialog.cancel();
            }
        });

        this.isLoading = isLoading;
        mListener = listener;
    }

    @Override
    public void onStart(int what) {

        if (isLoading && mWaitDialog != null && !mWaitDialog.isShowing()){

            mWaitDialog.show();
        }

    }

    @Override
    public void onSucceed(int what, Response<T> response) {
        if (mListener != null){

            mListener.onSucceed(what,response);
        }
    }

    @Override
    public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {

        if (mListener != null){

            mListener.onFailed(what,url,tag,exception,responseCode,networkMillis);
        }
    }

    @Override
    public void onFinish(int what) {

        if (isLoading && mWaitDialog != null && !mWaitDialog.isShowing()){

            mWaitDialog.cancel();
        }
    }
}
