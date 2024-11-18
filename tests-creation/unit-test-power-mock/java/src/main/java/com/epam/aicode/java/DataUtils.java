package com.epam.aicode.java;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class DataUtils {

    private DataUtils() {
    }

    public static String getIsoDateTime() {
        return LocalTime.now().format(DateTimeFormatter.ISO_DATE);
    }
}
