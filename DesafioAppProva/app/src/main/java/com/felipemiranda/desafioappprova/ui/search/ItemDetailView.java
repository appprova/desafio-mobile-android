package com.felipemiranda.desafioappprova.ui.search;

import com.felipemiranda.desafioappprova.model.ItemDetail;
import com.felipemiranda.desafioappprova.ui.main.BaseLoadingView;

import java.util.ArrayList;

/**
 * Created by felipemiranda on 27/10/17.
 */

public interface ItemDetailView extends BaseLoadingView {

    void successItemDetail(ArrayList<ItemDetail> response);
}
