package com.felipemiranda.desafioappprova.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by felipemiranda on 26/10/17.
 */

public class ApiCreator {

    private static final String API_BASE_URL = "https://api.github.com/";

    private static OkHttpClient httpClient = NetworkSetup.getClient();

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());


    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }
}
