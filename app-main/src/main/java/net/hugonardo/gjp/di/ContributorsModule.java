package net.hugonardo.gjp.di;

import net.hugonardo.gjp.main.MainContributorsModule;

import dagger.Module;

@Module(includes = {
        MainContributorsModule.class,
})
abstract class ContributorsModule {}
