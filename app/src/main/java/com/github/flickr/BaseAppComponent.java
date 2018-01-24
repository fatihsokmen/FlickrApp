package com.github.flickr;


import android.app.Application;

import com.github.flickr.api.ApiModule;
import com.github.flickr.api.FlickrApiService;
import com.github.flickr.scheduler.Scheduler;

import dagger.BindsInstance;

public interface BaseAppComponent {

    Scheduler provideScheduler();

    FlickrApiService provideFlickrApi();

    interface Builder<C extends BaseAppComponent, B extends Builder<C, B>> {

        @BindsInstance
        B application(Application application);

        @BindsInstance
        B apiModule(ApiModule apiModule);

        C build();
    }
}
