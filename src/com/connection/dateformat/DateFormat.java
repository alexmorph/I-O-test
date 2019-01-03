package com.connection.dateformat;

import java.util.Date;

public class DateFormat {

    public static String formatFileDate(String dateInMillis) {
        long time = Long.parseLong(dateInMillis);
        Date date = new Date(time);
        return java.text.DateFormat.getDateInstance().format(date);
    }
}
