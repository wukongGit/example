package com.example.bean;

import android.graphics.drawable.Drawable;

/**
 * Created by suncheng on 2016/4/17.
 */
public class AppInfo {
    private Drawable mIcon;
    private String mAppName;
    private String mPackageName;

    public Drawable getIcon() {
        return mIcon;
    }

    public void setIcon(Drawable mIcon) {
        this.mIcon = mIcon;
    }

    public String getAppName() {
        return mAppName;
    }

    public void setAppName(String mAppName) {
        this.mAppName = mAppName;
    }

    public String getPackageName() {
        return mPackageName;
    }

    public void setPackageName(String mPackageName) {
        this.mPackageName = mPackageName;
    }
}
