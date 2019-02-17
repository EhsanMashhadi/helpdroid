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

    /**
     * Check if the device is connected to the internet
     *
     * @param context The application context.
     * @return Returns true if the device is connected to the internet.
     */
    public static boolean isConnectedToInternet(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission")
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    /**
     * Return device name
     *
     * @return Returns device name of user.
     */
    public static String getDeviceName() {

        return android.os.Build.MODEL;
    }

    /**
     * Return device time zone
     *
     * @return Returns time zone of the device.
     */
    public static String getDeviceTimeZone() {

        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeZone().getID();
    }

    /**
     * Return Android ID of the device
     *
     * @return Returns Android ID of the device.
     */
    public static String getAndroidId(Context context) {

        String secureId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return secureId;
    }

    /**
     * Return device with value in pixel format
     *
     * @return Returns device width in pixel format.
     */
    public static int getDeviceWidthInPixel(Context context) {

        DisplayMetrics displayMetricsAdd = context.getResources().getDisplayMetrics();
        return displayMetricsAdd.widthPixels;
    }

    /**
     * Return device height value in pixel format
     *
     * @return Returns device height in pixel format.
     */
    public static int getDeviceHeightInPixel(Context context) {

        DisplayMetrics displayMetricsAdd = context.getResources().getDisplayMetrics();
        return displayMetricsAdd.heightPixels;
    }
}