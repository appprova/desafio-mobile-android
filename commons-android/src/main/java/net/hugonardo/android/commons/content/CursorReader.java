package net.hugonardo.android.commons.content;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Calendar;
import java.util.Date;

public class CursorReader {

    @Nullable
    public static Long readLong(@NonNull Cursor cursor, @NonNull String columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        return hasValue(cursor, columnIndex)
               ? cursor.getLong(columnIndex)
               : null;
    }

    @Nullable
    public static String readString(@NonNull Cursor cursor, @NonNull String columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        return hasValue(cursor, columnIndex)
               ? cursor.getString(columnIndex)
               : null;
    }

    @Nullable
    public static Date readDateFromMillis(@NonNull Cursor cursor, @NonNull String columnName) {
        Long timeInMillis = readLong(cursor, columnName);
        return timeInMillis != null
               ? new Date(timeInMillis)
               : null;
    }

    @Nullable
    public static Calendar readCalendarFromMillis(@NonNull Cursor cursor, @NonNull String columnName) {
        Long timeInMillis = readLong(cursor, columnName);
        if (timeInMillis == null) return null;

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        return calendar;
    }

    @Nullable
    public static Boolean readBoolean(@NonNull Cursor cursor, @NonNull String columnName) {
        Long longValue = readLong(cursor, columnName);
        return longValue != null
               ? longValue.equals(1L)
               : null;
    }

    @Nullable
    public static Integer readInteger(@NonNull Cursor cursor, @NonNull String columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        return hasValue(cursor, columnIndex)
                ? cursor.getInt(columnIndex)
                : null;
    }

    @Nullable
    public static Double readDouble(@NonNull Cursor cursor, @NonNull String columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        return hasValue(cursor, columnIndex)
                ? cursor.getDouble(columnIndex)
                : null;
    }

    private static boolean hasValue(Cursor cursor, int columnIndex) {
        return (columnIndex > -1) && !cursor.isNull(columnIndex);
    }
}
