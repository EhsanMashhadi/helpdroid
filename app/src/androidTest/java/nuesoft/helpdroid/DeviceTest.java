package nuesoft.helpdroid;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Assert;
import org.junit.Test;

import nuesoft.helpdroid.device.Device;

/**
 * Created by mysterious on 9/12/17.
 */

public class DeviceTest {


    @Test
    public void testIsConnectedToInternet() {

        Context context = InstrumentationRegistry.getTargetContext();
        Assert.assertTrue(Device.isConnectedToInternet(context));
    }
}
