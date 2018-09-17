package nuesoft.helpdroid.device;

import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;

import com.scottyab.rootbeer.RootBeer;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import nuesoft.helpdroid.application.AppSigner;

/**
 * Created by Ehsan on 3/23/18.
 */

public class Security {


    public static boolean isDeveloperOptionOn(Context context) {

        int adb = Settings.Secure.getInt(context.getContentResolver(), Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0);

        if (adb == 1) {
            return true;
        }
        return false;
    }

    public static boolean isPackageNameTampered(Context context, String packageName) {

        if (context.getPackageName().equals(packageName) == false) {
            return true;
        }
        return false;
    }

    public static boolean isCertificateTampered(Context context, String sha1Sign, String sha256Sign) throws CertificateException, NoSuchAlgorithmException, PackageManager.NameNotFoundException {







        try {

            String SHA1 = AppSigner.getSign(context, "SHA1");
            String SHA256 = AppSigner.getSign(context, "SHA256");

            if (!sha1Sign.equals(SHA1) || !sha256Sign.equals(SHA256)) {

                return true;
            }

        } catch (CertificateException e) {
            throw e;
        } catch (NoSuchAlgorithmException e) {
            throw e;

        } catch (PackageManager.NameNotFoundException e) {
            throw e;
        }
        return false;
    }

    public static boolean isRooted(Context context) {

        RootBeer rootBeer = new RootBeer(context);
        return rootBeer.isRooted();
    }

    public static boolean isRootedWithoutBusyBox(Context context) {

        RootBeer rootBeer = new RootBeer(context);
        return rootBeer.isRootedWithoutBusyBoxCheck();
    }
}
