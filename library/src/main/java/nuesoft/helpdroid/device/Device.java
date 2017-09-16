package nuesoft.helpdroid.device;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.Calendar;

/**
 * Created by mysterious on 9/12/17.
 */

public class Device {


    public static boolean isConnectedToInternet(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public static String getDeviceName() {

        return android.os.Build.MODEL;
    }

    public static String getDevieTimeZone() {

        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeZone().getID();
    }
}
