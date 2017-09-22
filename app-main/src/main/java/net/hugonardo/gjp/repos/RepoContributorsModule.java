package net.hugonardo.gjp.repos;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RepoContributorsModule {
    @ContributesAndroidInjector abstract RepoActivity contributesMainActivity();
    @ContributesAndroidInjector abstract RepoListFragment contributesRepoListFragment();
}
