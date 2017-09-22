package net.hugonardo.android.commons.recyclerview;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

public class AdapterUtils {

    public static boolean isNotEmpty(@Nullable RecyclerView.Adapter adapter) {
        return count(adapter) > 0;
    }

    public static int count(@Nullable RecyclerView.Adapter adapter) {
        return adapter == null
               ? 0
               : adapter instanceof RecyclerArrayAdapter
                 ? ((RecyclerArrayAdapter) adapter).getCount()
                 : adapter.getItemCount();
    }
}
