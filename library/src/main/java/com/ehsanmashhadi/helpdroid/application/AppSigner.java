package com.ehsanmashhadi.helpdroid.application;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.NonNull;
import com.ehsanmashhadi.helpdroid.util.Converter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Objects;

/**
 * Created by mysterious on 9/3/17.
 */

public class AppSigner {

    /**
     * Calculating the digest of application's signature
     *
     * @param context      The context of desired application.
     * @param digestType The desired digest method
     * @return Returns digest of application's signature in hex format
     * @throws NullPointerException                 If context or digestType is null.
     * @throws CertificateException                 If no Provider supports CertificateFactorySpi implementation for the specified type.
     * @throws NoSuchAlgorithmException             If no Provider supports a MessageDigestSpi implementation for the specified algorithm.
     * @throws PackageManager.NameNotFoundException If a package with the given name cannot be found on the system.
     * @see DigestType
     */
    public static String getSign(@NonNull Context context, @NonNull DigestType digestType) throws CertificateException
            , NoSuchAlgorithmException, PackageManager.NameNotFoundException {

        Objects.requireNonNull(context);
        Objects.requireNonNull(digestType);

        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        int flags = PackageManager.GET_SIGNATURES;
        PackageInfo packageInfo = packageManager.getPackageInfo(packageName, flags);
        Signature[] signatures = packageInfo.signatures;
        byte[] cert = signatures[0].toByteArray();
        InputStream input = new ByteArrayInputStream(cert);
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
        X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(input);
        MessageDigest messageDigest = MessageDigest.getInstance(digestType.getDigestMethod());
        byte[] publicKey = messageDigest.digest(certificate.getEncoded());
        return Converter.bytesToHexString(publicKey);
    }

    public enum DigestType {

        sha1("sha1"),
        sha256("sha-256"),
        sha512("sha-512");

        private final String mDigestMethod;

        DigestType(String digestMethod) {
            mDigestMethod = digestMethod;
        }

        public String getDigestMethod() {
            return mDigestMethod;
        }
    }
}