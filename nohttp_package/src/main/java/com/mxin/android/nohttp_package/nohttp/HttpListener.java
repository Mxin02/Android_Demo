package com.mxin.android.nohttp_package.nohttp;

import com.yolanda.nohttp.rest.Response;

/**
 * Created by Mxin on 2018/3/26.
 */

public interface HttpListener<T> {

    void onSucceed(int what, Response<T> response);
    void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis);
}
