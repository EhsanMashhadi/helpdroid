package nuesoft.helpdroid;

import android.content.Context;
import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.view.ContextThemeWrapper;

import com.scottyab.rootbeer.RootBeer;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SecurityTest {


    @Test
    public void isDeveloperOptionOn() {

        Context context = InstrumentationRegistry.getTargetContext();


    }

    @Test
    public void isPackageNameTampered() {


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

    }

}
