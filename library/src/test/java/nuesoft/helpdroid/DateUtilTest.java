package nuesoft.helpdroid;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.Locale;

import nuesoft.helpdroid.datetime.DateUtil;

public class DateUtilTest {

    @Test
    public void testDateToIs_notNull() {

        Date date = new Date(59 * 1000);
        String isoDate = DateUtil.dateToIso(date, Locale.US);
        Assert.assertEquals(isoDate, "1970-01-01T03:30:59.000");
    }

    @Test
    public void testIsoToDate_notNull() {

        String nowIso = DateUtil.nowToIso(Locale.US);
        Assert.assertNotNull(nowIso);
    }

    @Test
    public void testLastDayToIso_notNull() {

        String lastDayIso = DateUtil.lastDayToIso(Locale.US);
        Assert.assertNotNull(lastDayIso);
    }

    @Test
    public void testLastWeekToIso_notNull() {

        String lastWeekIso = DateUtil.lastWeekToIso(Locale.US);
        Assert.assertNotNull(lastWeekIso);
    }

    @Test
    public void testLastMonthToIso_notNull() {

        String lastMonthIso = DateUtil.lastMonthToIso(Locale.US);
        Assert.assertNotNull(lastMonthIso);
    }


}
