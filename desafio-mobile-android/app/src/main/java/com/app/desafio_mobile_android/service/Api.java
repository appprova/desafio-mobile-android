package com.app.desafio_mobile_android.service;

import com.app.desafio_mobile_android.service.model.pull.Pull;
import com.app.desafio_mobile_android.service.model.repositorie.Repositorie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("search/repositories?q=language:Java")
    Call<Repositorie> getRepositorieList(@Query("sort") String sortType,
                                         @Query("page") int pageNumber);

    @GET("/repos/{owner}/{repo}/pulls")
    Call<List<Pull>> getPullList(@Path("owner") String owner,
                                 @Path("repo") String repo,
                                 @Query("state") String state);
}
