package com.example.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.List;

/**
 * Created by suncheng on 2016/4/17.
 */
public class PackageUtils {
    public static void getAllApps(Context context, List<PackageInfo> systemApps, List<PackageInfo> customApps) {
        PackageManager pManager = context.getPackageManager();
        List<PackageInfo> paklist = pManager.getInstalledPackages(0);
        for (int i = 0; i < paklist.size(); i++) {
            PackageInfo pak = (PackageInfo) paklist.get(i);
            if ((pak.applicationInfo.flags & pak.applicationInfo.FLAG_SYSTEM) <= 0) {
                customApps.add(pak);
            } else {
                systemApps.add(pak);
            }
        }
    }
}
