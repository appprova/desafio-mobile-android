package com.felipemiranda.desafioappprova.network.api;

import com.felipemiranda.desafioappprova.model.ItemDetail;
import com.felipemiranda.desafioappprova.model.response.SearchResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by felipemiranda on 26/10/17.
 */

public interface SearchApi {

    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    Call<SearchResponse> requestSearch();

    @GET
    Call<ArrayList<ItemDetail>> requestItemDetail(@Url String url);
}
