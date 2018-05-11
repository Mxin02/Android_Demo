package com.mxin.android.toolbar_package;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by Mxin on 2018/3/26.
 */

public class ToolbarHelper {

    private  Toolbar mToolbar;
    /**上下文，创建View的时候用到**/
    private Context mContext;
    /** 根布局 **/
    private FrameLayout mContentView;

    /**打气筒**/
    LayoutInflater mInflater;

    private View mUserView;

    public ToolbarHelper(Context context, int layoutID) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);

        /**初始化整个内容**/
        initContentView();
        /**初始化用户自定义的布局**/
        initUserView(layoutID);
        /**初始化toolbar**/
        initToolbar();

    }

    private void initUserView(int layoutID) {

        mUserView = mInflater.inflate(layoutID, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        mContentView.setLayoutParams(params);
    }

    private void initToolbar() {
        View inflate = mInflater.inflate(R.layout.activity_toolbar, mContentView);
        mToolbar = inflate.findViewById(R.id.toolbar);

    }

    private void initContentView() {

        /**创建一个布局，作为视图容器的父容器**/
        mContentView = new FrameLayout(mContext);
        //设置容器的宽高
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        mContentView.setLayoutParams(params);
    }

    public  Toolbar getToolbar() {
        return mToolbar;
    }

    //返回视图容器方法
    public FrameLayout getContentView(){

        return mContentView;
    }
}
