package com.github.flickr;


import com.github.flickr.scheduler.Scheduler;
import com.github.flickr.scheduler.SchedulerImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module(includes = {
        AppModule.Bindings.class
})
class AppModule {

    @Module
    public interface Bindings {

        @Binds
        @Singleton
        Scheduler provideScheduler(SchedulerImpl impl);

    }
}
