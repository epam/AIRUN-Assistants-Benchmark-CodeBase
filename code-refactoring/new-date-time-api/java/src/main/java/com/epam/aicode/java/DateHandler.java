package com.epam.aicode.java;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateHandler {

    public Date getCurrentDate() {
        return new Date();
    }

    public String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public Date addDaysToCurrentDate(int daysToAdd) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);
        return calendar.getTime();
    }

    public String getDayOfWeek(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        return formatter.format(date);
    }
}