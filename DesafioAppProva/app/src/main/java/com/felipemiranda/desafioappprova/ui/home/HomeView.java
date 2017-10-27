package com.felipemiranda.desafioappprova.ui.home;

import com.felipemiranda.desafioappprova.model.response.SearchResponse;
import com.felipemiranda.desafioappprova.ui.main.BaseLoadingView;

/**
 * Created by felipemiranda on 26/10/17.
 */

public interface HomeView extends BaseLoadingView {

    void successSearch(SearchResponse response);
}
