package net.hugonardo.gjp.api.infra.di;

import android.support.annotation.Nullable;

import com.google.gson.Gson;

import net.hugonardo.gjp.api.infra.retrofit.JsonParserTool;
import net.hugonardo.gjp.api.infra.retrofit.NetworkMonitorInterceptor;
import net.hugonardo.java.commons.network.NetworkMonitor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiClientModule {

    @Provides @Singleton Retrofit retrofit(@BaseUrl String baseUrl, Gson gson, OkHttpClient httpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build();
    }

    @Provides @Singleton OkHttpClient httpClient(@Nullable NetworkMonitor networkMonitor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (networkMonitor != null) {
            builder.addInterceptor(new NetworkMonitorInterceptor(networkMonitor));
        }
        return builder.build();
    }

    @Provides @Singleton Gson gson() {
        return JsonParserTool.gson();
    }
}
