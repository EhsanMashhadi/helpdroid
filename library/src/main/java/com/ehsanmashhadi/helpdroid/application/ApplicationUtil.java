package com.ehsanmashhadi.helpdroid.application;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;

import java.util.Objects;

import android.os.Bundle;

import androidx.annotation.NonNull;

/**
 * Created by mysterious on 10/12/17.
 */

public class ApplicationUtil {

    /**
     * Restart the application and navigate to launch intent.
     *
     * @param context The context of desired application.
     */
    public static void restartApplication(@NonNull Context context) {
        Objects.requireNonNull(context);
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}
