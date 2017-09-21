package net.hugonardo.gjp.main;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainContributorsModule {
    @ContributesAndroidInjector abstract MainActivity contributesMainActivity();
}
