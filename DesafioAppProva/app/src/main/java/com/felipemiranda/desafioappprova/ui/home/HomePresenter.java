package com.felipemiranda.desafioappprova.ui.home;

import com.felipemiranda.desafioappprova.model.response.GenericErrorResponse;
import com.felipemiranda.desafioappprova.model.response.SearchResponse;
import com.felipemiranda.desafioappprova.network.ApiCreator;
import com.felipemiranda.desafioappprova.network.RestCallback;
import com.felipemiranda.desafioappprova.network.api.SearchApi;
import com.felipemiranda.desafioappprova.ui.main.BaseLoadingPresenter;

/**
 * Created by felipemiranda on 26/10/17.
 */

public class HomePresenter extends BaseLoadingPresenter<HomeView> {

    @Override
    public void bindView(HomeView view) {
        this.mView = view;
    }

    public void requestSearch() {
        addRequest(ApiCreator
                        .createService(SearchApi.class)
                        .requestSearch(),

                new RestCallback<SearchResponse>() {
                    @Override
                    public void onSuccess(SearchResponse response) {
                        mView.successSearch(response);
                    }

                    @Override
                    public void onError(GenericErrorResponse error) {
                        mView.notifyError(error);
                    }
                });
    }
}
