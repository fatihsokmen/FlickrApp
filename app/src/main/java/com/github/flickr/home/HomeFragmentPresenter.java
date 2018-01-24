package com.github.flickr.home;

import android.support.annotation.NonNull;

import com.github.flickr.home.data.PublicPhotosApiInteractor;
import com.github.flickr.home.data.PublicPhotosInteractor;
import com.github.flickr.scheduler.Scheduler;

import javax.inject.Inject;

public class HomeFragmentPresenter implements HomeFragmentContract.Presenter {

    private final @NonNull PublicPhotosInteractor apiInteractor;
    private final @NonNull Scheduler scheduler;

    @Inject
    HomeFragmentPresenter(@NonNull PublicPhotosInteractor apiInteractor,
                          @NonNull Scheduler scheduler) {
        this.apiInteractor = apiInteractor;
        this.scheduler = scheduler;
    }

    @Override
    public void init() {
    }
}
