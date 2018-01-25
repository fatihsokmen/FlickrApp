package com.github.flickr.home;

import android.support.annotation.NonNull;

import com.github.flickr.home.data.PhotoFeedDomain;
import com.github.flickr.home.data.PhotoFeedInteractor;
import com.github.flickr.scheduler.Scheduler;

import javax.inject.Inject;

import rx.SingleSubscriber;
import rx.subscriptions.CompositeSubscription;

public class HomeFragmentPresenter implements HomeFragmentContract.Presenter {

    private final @NonNull HomeFragmentContract.View view;
    private final @NonNull PhotoFeedInteractor apiInteractor;
    private final @NonNull Scheduler scheduler;

    private CompositeSubscription subscriptions = new CompositeSubscription();

    @Inject
    public HomeFragmentPresenter(
            @NonNull HomeFragmentContract.View view,
            @NonNull PhotoFeedInteractor apiInteractor,
            @NonNull Scheduler scheduler) {
        this.view = view;
        this.apiInteractor = apiInteractor;
        this.scheduler = scheduler;
    }

    @Override
    public void init() {
        view.showProgress(true);

        subscriptions.add(apiInteractor.getPhotos()
                .subscribeOn(scheduler.background())
                .observeOn(scheduler.main())
                .subscribe(new SingleSubscriber<PhotoFeedDomain>() {
                    @Override
                    public void onSuccess(PhotoFeedDomain photoFeed) {
                        view.bindData(photoFeed.entries);
                        view.showProgress(false);
                    }

                    @Override
                    public void onError(Throwable error) {
                        view.showProgress(false);
                    }
                }));
    }

    @Override
    public void clearSubscriptions() {
        subscriptions.clear();
    }
}
