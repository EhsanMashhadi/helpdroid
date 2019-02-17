package com.ehsanmashhadi.helpdroid;

import com.ehsanmashhadi.helpdroid.datetime.SolarHijriCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Calendar;

/**
 * Created by mysterious on 9/15/17.
 */

public class ShamsiCalendarTest {


    @Test
    public void convertGregorianToShamsiDateTest() {

//        String shamsiDateString = "180801";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
//        Date date = null;
//        try {
//            date = simpleDateFormat.parse(shamsiDateString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        String shamsiDate = SolarHijriCalendar.convertToShamsiDate(calendar);
//        Assert.assertEquals(shamsiDate, "1397/05/10");
    }

    @Test
    public void getCurrentShamsiDateTest(){
        //Mocking 2019/1/1
        Calendar calendar = Mockito.mock(Calendar.class);
        Mockito.when(calendar.get(Calendar.YEAR)).thenReturn(2019);
        Mockito.when(calendar.get(Calendar.MONTH)).thenReturn(0);
        Mockito.when(calendar.get(Calendar.DAY_OF_MONTH)).thenReturn(1);
        String shamsiDate= SolarHijriCalendar.getSolarHijriDate(calendar);
        Assert.assertEquals(shamsiDate,"1397/10/11");
    }
}
