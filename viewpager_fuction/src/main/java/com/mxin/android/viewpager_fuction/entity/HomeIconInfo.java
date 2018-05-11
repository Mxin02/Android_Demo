package com.mxin.android.viewpager_fuction.entity;

/**
 * Created by Mxin on 2018/3/26.
 */

public class HomeIconInfo {

    String iconName;
    int iconID;


    public HomeIconInfo(String iconName, int iconID) {
        this.iconName = iconName;
        this.iconID = iconID;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }
}
