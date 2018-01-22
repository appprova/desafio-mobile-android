package net.hugonardo.gjp.api.infra.di;

import android.support.annotation.Nullable;

import net.hugonardo.gjp.api.infra.util.Streams;
import net.hugonardo.java.commons.network.NetworkMonitor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.mockwebserver.MockWebServer;

@Module
class MockWebServerModule {

    @Provides @Singleton MockWebServer mockWebServer() {
        return new MockWebServer();
    }

    @Provides @BaseUrl String baseUrl(MockWebServer mockWebServer) {
        return mockWebServer.url("/").toString();
    }

    @Provides @Nullable NetworkMonitor networkMonitor() {
        return null;
    }

    @Provides @Singleton Streams utils() {
        return new Streams();
    }
}
