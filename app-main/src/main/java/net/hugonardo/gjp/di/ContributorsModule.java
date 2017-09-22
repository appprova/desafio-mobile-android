package net.hugonardo.gjp.di;

import net.hugonardo.gjp.main.MainContributorsModule;
import net.hugonardo.gjp.repos.RepoContributorsModule;

import dagger.Module;

@Module(includes = {
        MainContributorsModule.class,
        RepoContributorsModule.class,
})
abstract class ContributorsModule {}
