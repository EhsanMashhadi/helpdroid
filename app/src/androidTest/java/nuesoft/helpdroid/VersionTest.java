package nuesoft.helpdroid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.test.InstrumentationRegistry;

import org.junit.Assert;
import org.junit.Test;

import nuesoft.helpdroid.application.Version;


/**
 * Created by mysterious on 9/3/17.
 */

public class VersionTest {


    @Test
    public void testVersionName() {
        try {
            Context context = InstrumentationRegistry.getTargetContext();
            String versionName = Version.getVersionName(context);
            Assert.assertEquals(versionName, "1.0");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testVersionCode() {
        try {

            Context context = InstrumentationRegistry.getTargetContext();
            int versionCode = Version.getVersionCode(context);
            Assert.assertEquals(versionCode, 1);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
