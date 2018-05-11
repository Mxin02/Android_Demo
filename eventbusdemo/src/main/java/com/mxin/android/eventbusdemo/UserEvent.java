package com.mxin.android.eventbusdemo;

/**
 * Created by Mxin on 2018/3/29.
 */

public class UserEvent {

    String userName;
    String password;

    public UserEvent(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
