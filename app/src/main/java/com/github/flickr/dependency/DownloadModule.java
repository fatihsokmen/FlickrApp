package com.github.flickr.dependency;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.github.flickr.dependency.download.GlideImageDownloader;
import com.github.flickr.dependency.download.ImageDownloader;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module(includes = {
        DownloadModule.Bindings.class
})
public class DownloadModule {

    @Provides
    @Singleton
    RequestManager provideGlide(@NonNull Context context) {
        return Glide.with(context);
    }

    @Module
    public interface Bindings {
        @Binds
        @Singleton
        ImageDownloader provideFragmentPresenter(@NonNull GlideImageDownloader presenter);

    }

}