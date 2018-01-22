package net.hugonardo.gjp.api.infra.di;

import net.hugonardo.gjp.api.repo.RepoClientTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApiClientModule.class,
        MockWebServerModule.class,
})
public interface UnitTestComponent {

    void inject(RepoClientTest target);

    @Component.Builder
    interface Builder {
        UnitTestComponent build();
    }
}
