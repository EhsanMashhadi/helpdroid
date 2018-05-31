package nuesoft.helpdroid;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import nuesoft.helpdroid.network.SharedPreferencesJwtPersistor;


public class JwtPersistorTest {

    private static SharedPreferencesJwtPersistor sharedPreferencesJwtPersistor;

    @BeforeClass
    public static void setUp() {

        Context context = InstrumentationRegistry.getTargetContext();
        sharedPreferencesJwtPersistor = new SharedPreferencesJwtPersistor(context);
    }

    @Test
    public void saveJwt() {

        String jwt = "test";
        boolean result = sharedPreferencesJwtPersistor.save(jwt);
        Assert.assertTrue(result);
        String expectedJwt = sharedPreferencesJwtPersistor.get();
        Assert.assertEquals(jwt, expectedJwt);
    }

    @Test
    public void clearJwt() {

        String jwt = "test";
        boolean result = sharedPreferencesJwtPersistor.save(jwt);
        Assert.assertTrue(result);
        result = sharedPreferencesJwtPersistor.delete();
        Assert.assertTrue(result);
        String expectedJwt = sharedPreferencesJwtPersistor.get();
        Assert.assertNull(expectedJwt);
    }

}
