package com.ehsanmashhadi.helpdroid.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static String dateToIso(Date date, Locale locale) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", locale);
        return simpleDateFormat.format(date);
    }

    public static String timestampToIsoFormat(long timestamp, Locale locale) {

        return dateToIso(new Date(timestamp), locale);
    }
}
