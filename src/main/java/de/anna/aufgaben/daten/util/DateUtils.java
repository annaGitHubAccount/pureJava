package de.anna.aufgaben.daten.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Klasse final man kann nicht erweitern.
 */
public final class DateUtils {

    private DateUtils() {
    }

    public static Date createDate(int day, int month, int jahr){

        Calendar calendar = Calendar.getInstance();
        calendar.set(day, month, jahr);
        Date date = calendar.getTime();

        return date;
    }





}
