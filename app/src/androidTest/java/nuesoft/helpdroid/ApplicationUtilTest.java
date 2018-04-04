package nuesoft.helpdroid;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.mock.MockContext;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import nuesoft.helpdroid.application.ApplicationUtil;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
            Assert.fail();
        }
    }

    @Test
    public void testDebuggable(){

        Context context = mock(Context.class);
        when(context.getApplicationInfo().FLAG_DEBUGGABLE).thenReturn(2);
        Assert.assertTrue(ApplicationUtil.isDebuggable(context));

    }
}
