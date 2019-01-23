package com.ehsanmashhadi.helpdroid;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.ehsanmashhadi.helpdroid.application.ApplicationUtil;


/**
 * Created by mysterious on 10/12/17.
 */

@RunWith(AndroidJUnit4.class)
public class ApplicationUtilTest {


    Context context;
    @Test
    public void testRestartApplication() {

        Context context = InstrumentationRegistry.getTargetContext();

        try {
            ApplicationUtil.restartApplication(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDebuggable(){

        Context context = InstrumentationRegistry.getTargetContext();
        Assert.assertTrue(ApplicationUtil.isDebuggable(context));

    }
}
