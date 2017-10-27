package com.felipemiranda.desafioappprova.network;

import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by felipemiranda on 26/10/17.
 */

public class NetworkSetup {

    public static OkHttpClient getClient() {
        return new OkHttpClient()
                .newBuilder()
                .addInterceptor(getLoggingCapableHttpClient())
                .dispatcher(buildDispatcher())
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    private static HttpLoggingInterceptor getLoggingCapableHttpClient() {
        HttpLoggingInterceptor mLogging = new HttpLoggingInterceptor();
        mLogging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return mLogging;
    }

    private static Dispatcher buildDispatcher() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(20);
        return dispatcher;
    }
}
