package com.github.flickr.dependency;


import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.github.flickr.dependency.download.ImageDownloader;
import com.github.flickr.dependency.scheduler.Scheduler;

import dagger.BindsInstance;
import retrofit2.Retrofit;

public interface BaseAppComponent {

    Context provideApplicationContext();

    Scheduler provideScheduler();

    Retrofit provideRetrofit();

    ImageDownloader provideImageDownloader();

    interface Builder<C extends BaseAppComponent, B extends Builder<C, B>> {

        @BindsInstance
        B application(Application application);

        @BindsInstance
        B apiModule(NetModule apiModule);

        @BindsInstance
        B downloadModule(DownloadModule apiModule);

        C build();
    }
}
