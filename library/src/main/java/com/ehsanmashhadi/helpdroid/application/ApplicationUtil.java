package com.ehsanmashhadi.helpdroid.application;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;

/**
 * Created by mysterious on 10/12/17.
 */

public class ApplicationUtil {

    public static void restartApplication(Context context) throws Exception {

        Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (intent == null) {
            throw new NullPointerException();
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public static boolean isDebuggable(Context context) {

        boolean isDebuggable = ((context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0);
        return isDebuggable;
    }
}
