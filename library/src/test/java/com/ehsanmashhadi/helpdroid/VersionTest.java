package com.ehsanmashhadi.helpdroid;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ehsanmashhadi.helpdroid.application.Version;

import static org.mockito.Mockito.when;


/**
 * Created by mysterious on 9/3/17.
 */

public class VersionTest {

    @Mock
    Context context;

    @Mock
    PackageInfo packageInfo;

    @Mock
    PackageManager packageManager;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testVersionName() {

        try {
            when(context.getPackageName()).thenReturn("package_name");
            Assert.assertEquals(context.getPackageName(), "package_name");
            when(packageManager.getPackageInfo("package_name", 0)).thenReturn(packageInfo);
            when(context.getPackageManager()).thenReturn(packageManager);
            packageInfo.versionName = "1.0";
            String versionName = Version.getVersionName(context);
            Assert.assertEquals(versionName, "1.0");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testVersionCode() {

        try {

            when(context.getPackageName()).thenReturn("package_name");
            Assert.assertEquals(context.getPackageName(), "package_name");
            when(packageManager.getPackageInfo("package_name", 0)).thenReturn(packageInfo);
            when(context.getPackageManager()).thenReturn(packageManager);
            packageInfo.versionCode = 1;
            int versionCode = Version.getVersionCode(context);
            Assert.assertEquals(versionCode, 1);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

}
