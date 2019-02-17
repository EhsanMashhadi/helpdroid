package com.ehsanmashhadi.helpdroid.device;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;

import com.ehsanmashhadi.helpdroid.application.AppSigner;
import com.scottyab.rootbeer.RootBeer;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Objects;

import androidx.annotation.NonNull;

/**
 * Created by Ehsan on 3/23/18.
 */

public class Security {

    /**
     * Check if the application is debuggable or not.
     *
     * @param context The context of desired application to check.
     * @return Returns true if the application is debuggable, false otherwise.
     */
    public static boolean isDebuggable(@NonNull Context context) {
        Objects.requireNonNull(context);
        return ((context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0);
    }

    /**
     * Check if the developer option is on or not.
     *
     * @param context The context of desired application to check.
     * @return Returns true if the developer option is on, false otherwise.
     */
    public static boolean isDeveloperOptionOn(@NonNull Context context) {

        Objects.requireNonNull(context);
        return (Settings.Secure.getInt(context.getContentResolver(), Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0)) == 1;
    }

    /**
     * Check equality between package name of context with @param packageName.
     *
     * @param context The context of desired application to check.
     * @return Returns true if the package name is tampered, false otherwise.
     */
    public static boolean isPackageNameTampered(@NonNull Context context, @NonNull String packageName) {

        Objects.requireNonNull(context);
        Objects.requireNonNull(packageName);
        return !(context.getPackageName().equals(packageName));
    }

    /**
     * Check equality between digest value of the certificate of application
     * with @param digest value of the certificate of the context.
     *
     * @param context    The context of desired application to check.
     * @param sha1Sign   The SHA1 of application signature in HEX format.
     * @param sha256Sign The SHA256 of application signature in HEX format.
     * @return Returns true if the certificate is tampered, false otherwise.
     */
    public static boolean isCertificateTampered(@NonNull Context context, @NonNull String sha1Sign, @NonNull String sha256Sign)
            throws CertificateException, NoSuchAlgorithmException, PackageManager.NameNotFoundException {

        Objects.requireNonNull(context);
        Objects.requireNonNull(sha1Sign);
        Objects.requireNonNull(sha256Sign);

        String SHA1 = AppSigner.getSign(context, AppSigner.DigestType.sha1);
        String SHA256 = AppSigner.getSign(context, AppSigner.DigestType.sha256);

        return !sha1Sign.equals(SHA1) || !sha256Sign.equals(SHA256);
    }

    /**
     * Check if the device is rooted
     *
     * @param context The context of application to check.
     * @return Returns true if the device is rooted, false otherwise.
     */
    public static boolean isRooted(@NonNull Context context) {

        Objects.requireNonNull(context);
        RootBeer rootBeer = new RootBeer(context);
        return rootBeer.isRooted();
    }

    /**
     * Check if the device is rooted without busy box
     *
     * @param context The context of application to check.
     * @return Returns true if the device is rooted without busy box, false otherwise.
     */
    public static boolean isRootedWithoutBusyBox(@NonNull Context context) {

        Objects.requireNonNull(context);
        RootBeer rootBeer = new RootBeer(context);
        return rootBeer.isRootedWithoutBusyBoxCheck();
    }
}
