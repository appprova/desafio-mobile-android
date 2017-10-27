package com.felipemiranda.desafioappprova.ui.search;

import com.felipemiranda.desafioappprova.model.ItemDetail;
import com.felipemiranda.desafioappprova.model.response.GenericErrorResponse;
import com.felipemiranda.desafioappprova.network.ApiCreator;
import com.felipemiranda.desafioappprova.network.RestCallback;
import com.felipemiranda.desafioappprova.network.api.SearchApi;
import com.felipemiranda.desafioappprova.ui.main.BaseLoadingPresenter;

import java.util.ArrayList;

/**
 * Created by felipemiranda on 26/10/17.
 */

public class ItemDetailPresenter extends BaseLoadingPresenter<ItemDetailView> {

    @Override
    public void bindView(ItemDetailView view) {
        this.mView = view;
    }

    public void requestItemDetail(String url) {
        addRequest(ApiCreator
                        .createService(SearchApi.class)
                        .requestItemDetail(url),

                new RestCallback<ArrayList<ItemDetail>>() {
                    @Override
                    public void onSuccess(ArrayList<ItemDetail> response) {
                        mView.successItemDetail(response);
                    }

                    @Override
                    public void onError(GenericErrorResponse error) {
                        mView.notifyError(error);
                    }
                });
    }
}
