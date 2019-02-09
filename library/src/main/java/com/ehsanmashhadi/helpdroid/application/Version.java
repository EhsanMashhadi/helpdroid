package com.ehsanmashhadi.helpdroid.application;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;

import java.util.Objects;

/**
 * Created by mysterious on 9/12/17.
 */

public class Version {

    /**
     * Return the version name of the application which is defined in build.gradle file
     *
     * @param context The context of desired application.
     * @return Returns version name of the application.
     * @throws NullPointerException                 If context is null.
     * @throws PackageManager.NameNotFoundException If a package with the given name cannot be found on the system.
     */
    public static String getVersionName(@NonNull Context context) throws PackageManager.NameNotFoundException {

        Objects.requireNonNull(context);
        String packageName = context.getPackageName();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        return packageInfo.versionName;
    }

    /**
     * Return the version code of the application which is defined in build.gradle file.
     *
     * @param context The context of desired application.
     * @return Returns version name of the application.
     * @throws NullPointerException                 If context is null.
     * @throws PackageManager.NameNotFoundException If a package with the given name cannot be found on the system.
     */
    public static int getVersionCode(@NonNull Context context) throws PackageManager.NameNotFoundException {

        Objects.requireNonNull(context);
        String packageName = context.getPackageName();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        return packageInfo.versionCode;
    }
}