package com.ehsanmashhadi.helpdroid.application;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by mysterious on 9/12/17.
 */

public class Version {

    public static String getVersionName(Context context) throws PackageManager.NameNotFoundException {
        try {
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            String versionName = packageInfo.versionName;
            return versionName;
        } catch (PackageManager.NameNotFoundException e) {
            throw e;
        }
    }

    public static int getVersionCode(Context context) throws PackageManager.NameNotFoundException {
        try {
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            int versionCode = packageInfo.versionCode;
            return versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw e;
        }
    }

}
