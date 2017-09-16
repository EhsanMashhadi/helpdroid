package nuesoft.helpdroid.application;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * Created by mysterious on 9/3/17.
 */

public class AppSigner {

    public static String getSign(Context context, String algorithm) throws CertificateException, NoSuchAlgorithmException, PackageManager.NameNotFoundException {

        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        int flags = PackageManager.GET_SIGNATURES;
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(packageName, flags);
        } catch (PackageManager.NameNotFoundException e) {
            throw e;
        }
        Signature[] signatures = packageInfo.signatures;
        byte[] cert = signatures[0].toByteArray();
        InputStream input = new ByteArrayInputStream(cert);
        CertificateFactory certificateFactory = null;
        try {
            certificateFactory = CertificateFactory.getInstance("X509");
        } catch (CertificateException e) {
            throw e;
        }
        X509Certificate certificate = null;

        try {
            certificate = (X509Certificate) certificateFactory.generateCertificate(input);
        } catch (CertificateException e) {
            throw e;
        }
        String hexString = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            byte[] publicKey = messageDigest.digest(certificate.getEncoded());
            hexString = byte2HexFormatted(publicKey);
        } catch (NoSuchAlgorithmException e1) {
            throw e1;
        } catch (CertificateEncodingException e) {
            throw e;
        }
        return hexString;
    }

    private static String byte2HexFormatted(byte[] arr) {

        StringBuilder stringBuilder = new StringBuilder(arr.length * 2);
        for (int i = 0; i < arr.length; i++) {
            String hexString = Integer.toHexString(arr[i]);
            int l = hexString.length();
            if (l == 1) hexString = "0" + hexString;
            if (l > 2) hexString = hexString.substring(l - 2, l);
            stringBuilder.append(hexString.toUpperCase());

        }
        return stringBuilder.toString();
    }
}
