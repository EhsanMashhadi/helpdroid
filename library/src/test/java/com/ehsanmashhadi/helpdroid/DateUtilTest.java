package com.ehsanmashhadi.helpdroid;


import com.ehsanmashhadi.helpdroid.datetime.DateUtil;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.Locale;

public class DateUtilTest {


    @Test
    public void testDateToIso() {

        Date date = new Date(59 * 1000 *1000);
        String isoDate = DateUtil.dateToIso(date, Locale.US);
        Assert.assertEquals(isoDate, "1970-01-01T19:53:20.000");
    }

    @Test
    public void testTimeStampToIsoFormat() {

        String isoDate = DateUtil.timestampToIsoFormat(59*1000*1000,Locale.US);
        Assert.assertEquals(isoDate, "1970-01-01T19:53:20.000");
    }

}
