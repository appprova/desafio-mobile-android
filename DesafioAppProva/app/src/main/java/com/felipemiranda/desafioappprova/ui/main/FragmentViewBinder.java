package com.felipemiranda.desafioappprova.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by felipemiranda on 27/10/17.
 */

public interface FragmentViewBinder {
    View onCreateViewBinder(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);
}