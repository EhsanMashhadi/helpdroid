package com.ehsanmashhadi.helpdroid.app;


import android.content.Context;
import androidx.test.InstrumentationRegistry;

import org.junit.Assert;
import org.junit.Test;

import com.ehsanmashhadi.helpdroid.device.DeviceUtil;

/**
 * Created by mysterious on 9/12/17.
 */

public class DeviceUtilTest {


    @Test
    public void testIsConnectedToInternet() {

        Context context = InstrumentationRegistry.getTargetContext();
        Assert.assertTrue(DeviceUtil.isConnectedToInternet(context));
    }

    @Test
    public void testDeviceModel() {
        String deviceName = DeviceUtil.getDeviceName();
    }

    @Test
    public void testEmulatorModel() {
        String deviceName = DeviceUtil.getDeviceName();
    }

    @Test
    public void testTimeZone() {
        String timeZone = DeviceUtil.getDeviceTimeZone();
    }

    @Test
    public void testSecureId() {
        Context context = InstrumentationRegistry.getTargetContext();
        String secureId = DeviceUtil.getSecureId(context);
        Assert.assertNotNull(secureId);
    }
}
