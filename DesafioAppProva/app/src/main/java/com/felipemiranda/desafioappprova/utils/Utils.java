package com.felipemiranda.desafioappprova.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by felipemiranda on 27/10/17.
 */

public class Utils {

    public static Date getDate(String Date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(convertStringToDateComplete(Date));
        return cal.getTime();
    }

    public static Date convertStringToDateComplete(String date){
        return convertStringToDate(date, "yyyy-MM-dd'T'HH:mm:ss");
    }

    public static Date convertStringToDate(String date, String formatDate){
        if(date.isEmpty()) return null;

        try {
            SimpleDateFormat format = new SimpleDateFormat(formatDate);
            return format.parse(date);
        }catch (ParseException e){
            return null;
        }
    }
}
