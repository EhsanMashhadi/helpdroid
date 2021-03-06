package com.ehsanmashhadi.helpdroid.app;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import com.ehsanmashhadi.helpdroid.device.Security;

@RunWith(AndroidJUnit4.class)
public class SecurityTest {

    @Test
    public void isDeveloperOptionOn() {

        Context context = InstrumentationRegistry.getTargetContext();
        boolean isDeveloperOptionOn = Security.isDeveloperOptionOn(context);
    }

    @Test
    public void isPackageNameTampered() {

        Context context = InstrumentationRegistry.getTargetContext();
        boolean isPackageNameTampered = Security.isPackageNameTampered(context, "com.ehsanmashhadi.helpdroid.app");
        Assert.assertTrue(!isPackageNameTampered);
    }

    @Test
    public void isCertificateTampered() throws CertificateException, NoSuchAlgorithmException, PackageManager.NameNotFoundException {

        Context context = InstrumentationRegistry.getTargetContext();
        boolean isCertificateTampered = Security.isCertificateTampered(context, "E31DE24C0976371BCAE8810C25F4D13473DE4FE0",
                "87DBE3FCBDFEACE63FF1E59ED73CDB04B670E0A9B517A6CE96EE5A0117FD6737");
    }


    @Test
    public void isRooted() {

        Context context = InstrumentationRegistry.getTargetContext();
        boolean isRooted = Security.isRooted(context);
    }

    @Test
    public void isRootedWithoutBusyBox() {

        Context context = InstrumentationRegistry.getTargetContext();
        boolean isRootedWithoutBusyBox = Security.isRootedWithoutBusyBox(context);
    }
}