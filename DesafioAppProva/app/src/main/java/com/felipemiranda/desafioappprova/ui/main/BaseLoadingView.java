package com.felipemiranda.desafioappprova.ui.main;

import com.felipemiranda.desafioappprova.model.response.GenericErrorResponse;

/**
 * Created by felipemiranda on 26/10/17.
 */

public interface BaseLoadingView extends FragmentViewBinder {

    void showLoading();

    void hideLoading();

    void notifyError(GenericErrorResponse error);

    void retryLastRequest();
}
