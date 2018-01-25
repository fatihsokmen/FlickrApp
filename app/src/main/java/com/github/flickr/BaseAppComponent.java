package com.github.flickr;


import android.app.Application;
import android.content.Context;

import com.github.flickr.scheduler.Scheduler;

import dagger.BindsInstance;
import retrofit2.Retrofit;

public interface BaseAppComponent {

    Context provideApplicationContext();

    Scheduler provideScheduler();

    Retrofit provideRetrofit();

    interface Builder<C extends BaseAppComponent, B extends Builder<C, B>> {

        @BindsInstance
        B application(Application application);

        @BindsInstance
        B apiModule(NetModule apiModule);

        C build();
    }
}
