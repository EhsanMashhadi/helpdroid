package nuesoft.helpdroid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.scottyab.rootbeer.RootBeer;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import nuesoft.helpdroid.application.AppSigner;

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
    public void isCertificateTampered() throws CertificateException, NoSuchAlgorithmException, PackageManager.NameNotFoundException {

        Context context=InstrumentationRegistry.getTargetContext();
        String SHA1,SHA256;
        SHA1=AppSigner.getSign(context,"SHA1");
        SHA256=AppSigner.getSign(context,"SHA256");
        Assert.assertEquals(SHA1,"E31DE24C0976371BCAE8810C25F4D13473DE4FE0");
        Assert.assertEquals(SHA256,"87DBE3FCBDFEACE63FF1E59ED73CDB04B670E0A9B517A6CE96EE5A0117FD6737");
        org.junit.Assert.assertNotEquals(SHA1,"");
        org.junit.Assert.assertNotEquals(SHA256,"");
        org.junit.Assert.assertNotEquals(SHA1,null);
        org.junit.Assert.assertNotEquals(SHA256,null);

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
