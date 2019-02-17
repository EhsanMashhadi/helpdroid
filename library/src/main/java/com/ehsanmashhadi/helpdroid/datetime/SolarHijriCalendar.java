package com.ehsanmashhadi.helpdroid.datetime;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Ehsan on 2016-07-09.
 */
public class SolarHijriCalendar {

    private int date;
    private int month;
    private int year;
    private Calendar mGregorianCalendar;

    public SolarHijriCalendar(Calendar gregorianCalendar) {

        mGregorianCalendar = gregorianCalendar;
    }

    private void convert() {

        int ld;

        String strWeekDay;
        String strMonth;

        int year = mGregorianCalendar.get(Calendar.YEAR) ;
        int month = mGregorianCalendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = mGregorianCalendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = mGregorianCalendar.get(Calendar.DAY_OF_WEEK);

        int[] buf1 = new int[12];
        int[] buf2 = new int[12];

        buf1[0] = 0;
        buf1[1] = 31;
        buf1[2] = 59;
        buf1[3] = 90;
        buf1[4] = 120;
        buf1[5] = 151;
        buf1[6] = 181;
        buf1[7] = 212;
        buf1[8] = 243;
        buf1[9] = 273;
        buf1[10] = 304;
        buf1[11] = 334;

        buf2[0] = 0;
        buf2[1] = 31;
        buf2[2] = 60;
        buf2[3] = 91;
        buf2[4] = 121;
        buf2[5] = 152;
        buf2[6] = 182;
        buf2[7] = 213;
        buf2[8] = 244;
        buf2[9] = 274;
        buf2[10] = 305;
        buf2[11] = 335;

        if ((year % 4) != 0) {
            date = buf1[month - 1] + dayOfMonth;

            if (date > 79) {
                date = date - 79;
                if (date <= 186) {
                    switch (date % 31) {
                        case 0:
                            this.month = date / 31;
                            date = 31;
                            break;
                        default:
                            this.month = (date / 31) + 1;
                            date = (date % 31);
                            break;
                    }
                    this.year = year - 621;
                } else {
                    date = date - 186;

                    switch (date % 30) {
                        case 0:
                            this.month = (date / 30) + 6;
                            date = 30;
                            break;
                        default:
                            this.month = (date / 30) + 7;
                            date = (date % 30);
                            break;
                    }
                    this.year = year - 621;
                }
            } else {
                if ((year > 1996) && (year % 4) == 1) {
                    ld = 11;
                } else {
                    ld = 10;
                }
                date = date + ld;

                switch (date % 30) {
                    case 0:
                        this.month = (date / 30) + 9;
                        date = 30;
                        break;
                    default:
                        this.month = (date / 30) + 10;
                        date = (date % 30);
                        break;
                }
                this.year = year - 622;
            }
        } else {
            date = buf2[month - 1] + dayOfMonth;

            if (year >= 1996) {
                ld = 79;
            } else {
                ld = 80;
            }
            if (date > ld) {
                date = date - ld;

                if (date <= 186) {
                    switch (date % 31) {
                        case 0:
                            this.month = (date / 31);
                            date = 31;
                            break;
                        default:
                            this.month = (date / 31) + 1;
                            date = (date % 31);
                            break;
                    }
                    this.year = year - 621;
                } else {
                    date = date - 186;

                    switch (date % 30) {
                        case 0:
                            this.month = (date / 30) + 6;
                            date = 30;
                            break;
                        default:
                            this.month = (date / 30) + 7;
                            date = (date % 30);
                            break;
                    }
                    this.year = year - 621;
                }
            } else {
                date = date + 10;

                switch (date % 30) {
                    case 0:
                        this.month = (date / 30) + 9;
                        date = 30;
                        break;
                    default:
                        this.month = (date / 30) + 10;
                        date = (date % 30);
                        break;
                }
                this.year = year - 622;
            }

        }

        switch (this.month) {
            case 1:
                strMonth = "فروردين";
                break;
            case 2:
                strMonth = "ارديبهشت";
                break;
            case 3:
                strMonth = "خرداد";
                break;
            case 4:
                strMonth = "تير";
                break;
            case 5:
                strMonth = "مرداد";
                break;
            case 6:
                strMonth = "شهريور";
                break;
            case 7:
                strMonth = "مهر";
                break;
            case 8:
                strMonth = "آبان";
                break;
            case 9:
                strMonth = "آذر";
                break;
            case 10:
                strMonth = "دي";
                break;
            case 11:
                strMonth = "بهمن";
                break;
            case 12:
                strMonth = "اسفند";
                break;
        }

        switch (dayOfWeek) {
            case 0:
                strWeekDay = "يکشنبه";
                break;
            case 1:
                strWeekDay = "دوشنبه";
                break;
            case 2:
                strWeekDay = "سه شنبه";
                break;
            case 3:
                strWeekDay = "چهارشنبه";
                break;
            case 4:
                strWeekDay = "پنج شنبه";
                break;
            case 5:
                strWeekDay = "جمعه";
                break;
            case 6:
                strWeekDay = "شنبه";
                break;
        }
    }

    public static String getSolarHijriDate(Calendar calendar) {

        Locale loc = new Locale("en_US");
        SolarHijriCalendar solarHijriCalendar = new SolarHijriCalendar(calendar);
        solarHijriCalendar.convert();

        return String.valueOf(solarHijriCalendar.year) + "/" + String.format(loc, "%02d",
                solarHijriCalendar.month) + "/" + String.format(loc, "%02d", solarHijriCalendar.date);
    }
}