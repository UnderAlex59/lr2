package ru.zverev.lr2.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeUtil {

    public static SimpleDateFormat getCustomFormat() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    }

    public static Integer getDaysInYear() {
        return Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    public static Integer getDaysInQuarter() {
        return getDaysInYear() / 4;
    }
}
