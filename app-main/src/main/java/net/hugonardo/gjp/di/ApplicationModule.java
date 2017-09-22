package net.hugonardo.gjp.di;

import android.content.Context;

import net.hugonardo.gjp.BuildConfig;
import net.hugonardo.gjp.GjpApplication;
import net.hugonardo.gjp.api.infra.Host;
import net.hugonardo.gjp.api.infra.di.BaseUrl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class ApplicationModule {
    @Provides Context context(GjpApplication application) {
        return application;
    }
    @Provides @Singleton @BaseUrl String baseUrl() {
        return Host.fromBuildType(BuildConfig.BUILD_TYPE).getBaseUrl();
    }
}
