package com.ehsanmashhadi.helpdroid.device;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.util.DisplayMetrics;

import java.util.Calendar;

/**
 * Created by mysterious on 9/12/17.
 */

public class DeviceUtil {


    public static boolean isConnectedToInternet(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission")
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public static String getDeviceName() {

        return android.os.Build.MODEL;
    }

    public static String getDeviceTimeZone() {

        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeZone().getID();
    }

    public static String getSecureId(Context context) {

        String secureId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return secureId;
    }

    public static int getDeviceWidthInPixel() {

        DisplayMetrics displayMetricsAdd = Resources.getSystem().getDisplayMetrics();
        return displayMetricsAdd.widthPixels;
    }

    public static int getDeviceHeightInPixel() {

        DisplayMetrics displayMetricsAdd = Resources.getSystem().getDisplayMetrics();
        return displayMetricsAdd.heightPixels;
    }
}
