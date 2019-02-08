package com.ehsanmashhadi.helpdroid.app;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import com.ehsanmashhadi.helpdroid.application.AppSigner;

/**
 * Created by mysterious on 9/3/17.
 */

@RunWith(AndroidJUnit4.class)
public class AppSignerTest {

    @Test
    public void testSha1() {

        Context context = InstrumentationRegistry.getTargetContext();

        String sha1Sign = null;
        try {
            sha1Sign = AppSigner.getSign(context, "SHA1");
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(sha1Sign);
        Assert.assertEquals(sha1Sign, "137DDBF6E8938F3262E373DE1D445B8EB3C7EC16");
    }

    @Test
    public void testSha2() {

        Context context = InstrumentationRegistry.getTargetContext();
        String sha2Sign = null;
        try {
            sha2Sign = AppSigner.getSign(context, "SHA256");
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(sha2Sign);
        Assert.assertEquals(sha2Sign, "6AB5DCBC86F78A1ADFF141FB2C75D75552ADA0CEC8F12229E54837F35CCA6B72");
    }
}
