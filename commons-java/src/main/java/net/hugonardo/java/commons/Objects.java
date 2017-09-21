package net.hugonardo.java.commons;

import com.google.gson.GsonBuilder;

public class Objects {

    public static boolean equals(Object var0, Object var1) {
        return var0 == var1 || var0 != null && var0.equals(var1);
    }

    public static boolean notEquals(Object var0, Object var1) {
        return !equals(var0, var1);
    }

    public static boolean isNull(Object value) {
        return value == null;
    }

    public static boolean isNotNull(Object value) {
        return !isNull(value);
    }

    public static String toString(Object o) {
        String prefix = o.getClass().getSimpleName() + ": ";
        return prefix + new GsonBuilder()
                .serializeNulls()
                .create()
                .toJson(o);
    }
}
