package com.ehsanmashhadi.helpdroid;


import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;

import com.ehsanmashhadi.helpdroid.device.DeviceUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.TimeZone;

/**
 * Created by mysterious on 9/12/17.
 */

public class DeviceUtilTest {

    @Mock
    private Context mContext;

    @Mock
    private ConnectivityManager mConnectivityManager;

    @Mock
    private NetworkInfo mNetworkInfo;

    @Mock
    private Resources mResources;

    @Mock
    private DisplayMetrics mDisplayMetrics;



    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIsConnectedToInternet_true() {

        Mockito.when(mContext.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(mConnectivityManager);
        Mockito.when(mConnectivityManager.getActiveNetworkInfo()).thenReturn(mNetworkInfo);
        Mockito.when(mNetworkInfo.isConnectedOrConnecting()).thenReturn(true);
        Assert.assertTrue(DeviceUtil.isConnectedToInternet(mContext));
    }

    @Test
    public void testIsConnectedToInternet_false() {

        Mockito.when(mContext.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(mConnectivityManager);
        Mockito.when(mConnectivityManager.getActiveNetworkInfo()).thenReturn(mNetworkInfo);
        Mockito.when(mNetworkInfo.isConnectedOrConnecting()).thenReturn(false);
        Assert.assertFalse(DeviceUtil.isConnectedToInternet(mContext));
    }

    @Test
    public void testDeviceModel_mockModel() throws Exception {

        Util.setFinalStatic(Build.class.getDeclaredField("MODEL"), "Mock Model");
        String deviceName = DeviceUtil.getDeviceName();
        Assert.assertEquals(deviceName, "Mock Model");
    }

    @Test
    public void testTimeZone(){

        TimeZone.setDefault(TimeZone.getTimeZone("Etc/GMT"));
        String timeZone = DeviceUtil.getDeviceTimeZone();
        Assert.assertEquals(timeZone,"Etc/GMT");
    }

    @Test
    public void testSecureId() throws Exception {

        Util.setFinalStatic(Settings.Secure.class.getDeclaredField("ANDROID_ID"), "Test");
        Assert.assertEquals(DeviceUtil.getAndroidId(mContext),"Test");
    }

    @Test
    public void testGetDeviceWidthInPixel(){
        Mockito.when(mContext.getResources()).thenReturn(mResources);
        Mockito.when(mResources.getDisplayMetrics()).thenReturn(mDisplayMetrics);
        mDisplayMetrics.widthPixels = 10;
        Assert.assertEquals(DeviceUtil.getDeviceWidthInPixel(mContext),10);
    }

    @Test
    public void testGetDeviceHeightInPixel(){
        Mockito.when(mContext.getResources()).thenReturn(mResources);
        Mockito.when(mResources.getDisplayMetrics()).thenReturn(mDisplayMetrics);
        mDisplayMetrics.heightPixels = 10;
        Assert.assertEquals(DeviceUtil.getDeviceHeightInPixel(mContext),10);
    }
}
