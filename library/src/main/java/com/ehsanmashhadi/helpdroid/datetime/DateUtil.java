package com.ehsanmashhadi.helpdroid.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static String dateToIso(Date date, Locale locale) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", locale);
        return simpleDateFormat.format(date);
    }

    public static String nowToIso(Locale locale) {

        Date date = new Date(System.currentTimeMillis());
        return dateToIso(date, locale);
    }

    public static String lastDayToIso(Locale locale) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date date = calendar.getTime();
        return dateToIso(date, locale);
    }

    public static String lastWeekToIso(Locale locale) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        Date date = calendar.getTime();
        return dateToIso(date, locale);
    }

    public static String lastMonthToIso(Locale locale) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        Date date = calendar.getTime();
        return dateToIso(date, locale);
    }
}
