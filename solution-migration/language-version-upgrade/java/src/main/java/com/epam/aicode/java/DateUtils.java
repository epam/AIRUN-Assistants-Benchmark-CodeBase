package com.epam.aicode.java;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    public static final long daysBetween(Date date1, Date date2) {
        long diff = date2.getTime() - date1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
