package com.mxin.android.toolbar_package;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onCreateCustomToolbar(Toolbar toolbar) {
        super.onCreateCustomToolbar(toolbar);

        //menu悬浮在上面
        toolbar.showOverflowMenu();
    }
}
