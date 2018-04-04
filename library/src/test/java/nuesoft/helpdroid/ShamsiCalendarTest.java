package nuesoft.helpdroid;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import nuesoft.helpdroid.util.ShamsiCalendar;

/**
 * Created by mysterious on 9/15/17.
 */

public class ShamsiCalendarTest {
    
    @Test
    public void convertToShamsiDateTest() {

        String shamsiDateString = "180801";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(shamsiDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String shamsiDate = ShamsiCalendar.convertToShamsiDate(date);
        Assert.assertEquals(shamsiDate, "1397/05/10");
    }
}
