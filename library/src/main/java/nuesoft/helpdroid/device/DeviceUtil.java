package nuesoft.helpdroid.device;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;

import java.util.Calendar;

/**
 * Created by mysterious on 9/12/17.
 */

public class DeviceUtil {


    public static boolean isConnectedToInternet(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
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
}
