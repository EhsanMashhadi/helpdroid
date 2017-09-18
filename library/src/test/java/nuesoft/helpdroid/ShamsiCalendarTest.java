package nuesoft.helpdroid;

import org.junit.Assert;
import org.junit.Test;

import nuesoft.helpdroid.util.ShamsiCalendar;

/**
 * Created by mysterious on 9/15/17.
 */

public class ShamsiCalendarTest {

    @Test
    public void currentDate() {
        String currentDate = ShamsiCalendar.getCurrentShamsiDate();
        Assert.assertEquals(currentDate, "1396/06/24");
    }
}
