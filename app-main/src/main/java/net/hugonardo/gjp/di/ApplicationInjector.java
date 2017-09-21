package net.hugonardo.gjp.di;

import net.hugonardo.gjp.GjpApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ContributorsModule.class,
        ApplicationModule.class,
})
public interface ApplicationInjector extends AndroidInjector<GjpApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<GjpApplication> {
        @Override public abstract ApplicationInjector build();
    }
}
