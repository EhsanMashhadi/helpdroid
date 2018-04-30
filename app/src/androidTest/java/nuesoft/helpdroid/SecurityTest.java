package nuesoft.helpdroid;

import android.content.Context;
import android.provider.Settings;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.scottyab.rootbeer.RootBeer;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SecurityTest {


    @Test
    public void isDeveloperOptionOn() throws Settings.SettingNotFoundException {

        Context context = InstrumentationRegistry.getTargetContext();
        int state= Settings.Secure.getInt(context.getContentResolver(),Settings.Global.DEVELOPMENT_SETTINGS_ENABLED);
        Assert.assertEquals(state,1);
        org.junit.Assert.assertNotEquals(state,0);

    }

    @Test
    public void isPackageNameTampered() {

        Boolean state;
        Context context=InstrumentationRegistry.getTargetContext();
        if(context.getPackageName().equals("nuesoft.helpdroid.application")){

            state=false;
        }
        else{

            state=true;
        }
        Assert.assertTrue(!state);
        Assert.assertFalse(state);

    }

    @Test
    public void isCertificateTampered() {


    }

    @Test
    public void isRooted() {
        Context context=InstrumentationRegistry.getTargetContext();
        RootBeer rootBeer=new RootBeer(context);
        Boolean state=rootBeer.isRooted();
        Assert.assertFalse(state);

    }

    @Test
    public void isRootedWithoutBusyBox() {

        Context context=InstrumentationRegistry.getTargetContext();
        RootBeer rootBeer=new RootBeer(context);
        Boolean state=rootBeer.isRootedWithoutBusyBoxCheck();
        Assert.assertFalse(state);

    }

}
