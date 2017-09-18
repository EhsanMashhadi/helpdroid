package nuesoft.helpdroid;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Assert;
import org.junit.Test;

import nuesoft.helpdroid.device.DeviceUtil;

/**
 * Created by mysterious on 9/12/17.
 */

public class DeviceParserTest {


    @Test
    public void testIsConnectedToInternet() {

        Context context = InstrumentationRegistry.getTargetContext();
        Assert.assertTrue(DeviceUtil.isConnectedToInternet(context));
    }

    @Test
    public void testDeviceModel() {
        String deviceName = DeviceUtil.getDeviceName();
        Assert.assertEquals(deviceName, "LG-K520");
    }

    @Test
    public void testEmulatorModel() {
        String deviceName = DeviceUtil.getDeviceName();
        Assert.assertEquals(deviceName, "Android SDK built for x86");
    }

    @Test
    public void testTimeZoen() {
        String timeZone = DeviceUtil.getDeviceTimeZone();
        Assert.assertEquals(timeZone, "Asia/Tehran");
    }
}