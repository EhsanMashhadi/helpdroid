package com.ehsanmashhadi.helpdroid.app;

import android.content.Context;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.ehsanmashhadi.helpdroid.application.ApplicationUtil;


/**
 * Created by mysterious on 10/12/17.
 */

@RunWith(AndroidJUnit4.class)
public class ApplicationUtilTest {

    @Test
    public void testRestartApplication() {

        Context context = InstrumentationRegistry.getTargetContext();

        try {
            ApplicationUtil.restartApplication(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
