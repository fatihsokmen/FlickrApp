package com.github.flickr.home;

import android.support.annotation.NonNull;

import com.github.flickr.home.data.PhotoFeedDTO;
import com.github.flickr.home.data.PhotoFeedInteractor;
import com.github.flickr.scheduler.Scheduler;

import javax.inject.Inject;

import rx.SingleSubscriber;

public class HomeFragmentPresenter implements HomeFragmentContract.Presenter {

    private final @NonNull
    PhotoFeedInteractor apiInteractor;
    private final @NonNull Scheduler scheduler;

    @Inject
    HomeFragmentPresenter(@NonNull PhotoFeedInteractor apiInteractor,
                          @NonNull Scheduler scheduler) {
        this.apiInteractor = apiInteractor;
        this.scheduler = scheduler;
    }

    @Override
    public void init() {
        apiInteractor.getPhotos()
            .subscribeOn(scheduler.background())
            .observeOn(scheduler.main())
            .subscribe(new SingleSubscriber<PhotoFeedDTO>() {
                @Override
                public void onSuccess(PhotoFeedDTO photoFeedDTO) {
                }

                @Override
                public void onError(Throwable error) {
                }
            });
    }
}
