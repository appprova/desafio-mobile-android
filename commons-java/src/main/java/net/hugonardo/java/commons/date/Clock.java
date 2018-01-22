package net.hugonardo.java.commons.date;

import java.util.Calendar;
import java.util.Date;

public interface Clock {

    long getCurrentTimeInMillis();

    Date getDate();

    Calendar getCalendar();
}
