package net.hugonardo.java.commons.collections;

import java.util.Collection;

public final class Collections {

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    public static <T> boolean isNotEmpty(T[] array) {
        return !isEmpty(array);
    }

    public static <T> boolean contains(T[] array, T item) {
        if (array == null) return false;
        for (T t : array) {
            if (t == null && item == null) return true;
            if (t != null && t.equals(item)) return true;
        }
        return false;
    }
}
