package nuesoft.helpdroid;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Assert;
import org.junit.Test;

import nuesoft.helpdroid.device.RootChecker;

/**
 * Created by mysterious on 9/3/17.
 */

public class RootCheckerTest {

    @Test
    public void isRooted() {

        Context context = InstrumentationRegistry.getTargetContext();
        boolean isRooted = RootChecker.isRooted(context);
        Assert.assertTrue(isRooted);
    }

    @Test
    public void isRootedWithoutBusyBox() {

        Context context = InstrumentationRegistry.getTargetContext();
        boolean isRooted = RootChecker.isRootedWithoutBusyBox(context);
        Assert.assertTrue(isRooted);
    }
}