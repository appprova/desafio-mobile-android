package net.hugonardo.android.commons.recyclerview;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

public class AdapterUtils {

    public static boolean isNotEmpty(@Nullable RecyclerView.Adapter adapter) {
        return count(adapter) > 0;
    }

    public static int count(@Nullable RecyclerView.Adapter adapter) {
        return adapter != null ? adapter.getItemCount() : 0;
    }
}
