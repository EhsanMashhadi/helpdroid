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
    private Context mContext;

    @Mock
    private PackageInfo mPackageInfo;

    @Mock
    private PackageManager mPackageManager;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVersionName() throws PackageManager.NameNotFoundException {

        when(mContext.getPackageName()).thenReturn("package_name");
        Assert.assertEquals(mContext.getPackageName(), "package_name");
        when(mPackageManager.getPackageInfo("package_name", 0)).thenReturn(mPackageInfo);
        when(mContext.getPackageManager()).thenReturn(mPackageManager);
        mPackageInfo.versionName = "1.0.0";
        String versionName = Version.getVersionName(mContext);
        Assert.assertEquals(versionName, "1.0.0");
    }

    @Test
    public void testVersionCode() throws PackageManager.NameNotFoundException {

        when(mContext.getPackageName()).thenReturn("package_name");
        Assert.assertEquals(mContext.getPackageName(), "package_name");
        when(mPackageManager.getPackageInfo("package_name", 0)).thenReturn(mPackageInfo);
        when(mContext.getPackageManager()).thenReturn(mPackageManager);
        mPackageInfo.versionCode = 1;
        int versionCode = Version.getVersionCode(mContext);
        Assert.assertEquals(versionCode, 1);
    }
}
