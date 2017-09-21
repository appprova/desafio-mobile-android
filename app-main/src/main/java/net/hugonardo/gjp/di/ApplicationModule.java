package net.hugonardo.gjp.di;

import android.content.Context;

import net.hugonardo.gjp.GjpApplication;

import dagger.Module;
import dagger.Provides;

@Module
class ApplicationModule {
    @Provides Context context(GjpApplication application) {
        return application;
    }
}
