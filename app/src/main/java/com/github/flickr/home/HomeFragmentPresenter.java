package com.github.flickr.home;

import android.support.annotation.NonNull;

import com.github.flickr.dependency.download.BitmapHolder;
import com.github.flickr.dependency.download.ImageDownloader;
import com.github.flickr.dependency.scheduler.Scheduler;
import com.github.flickr.home.data.PhotoFeedDomain;
import com.github.flickr.home.data.PhotoFeedInteractor;

import javax.inject.Inject;

import rx.SingleSubscriber;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

public class HomeFragmentPresenter implements HomeFragmentContract.Presenter {

    private final @NonNull
    HomeFragmentContract.View view;
    private final @NonNull
    PhotoFeedInteractor apiInteractor;
    private final @NonNull
    ImageDownloader imageDownloader;
    private final @NonNull
    Scheduler scheduler;

    private CompositeSubscription subscriptions = new CompositeSubscription();

    @Inject
    public HomeFragmentPresenter(
            @NonNull HomeFragmentContract.View view,
            @NonNull PhotoFeedInteractor apiInteractor,
            @NonNull ImageDownloader imageDownloader,
            @NonNull Scheduler scheduler) {
        this.view = view;
        this.apiInteractor = apiInteractor;
        this.imageDownloader = imageDownloader;
        this.scheduler = scheduler;
    }

    @Override
    public void init() {
        view.showProgress(true);

        subscriptions.clear();
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
                        view.showError("Error loading photo feed");
                    }
                }));
    }

    @Override
    public void sharePhoto(@NonNull String photoUrl) {
        view.showProgress(true);

        subscriptions.clear();
        subscriptions.add(imageDownloader.downloadBitmap(photoUrl)
                .subscribeOn(scheduler.background())
                .observeOn(scheduler.main())
                .subscribe(new Subscriber<BitmapHolder>() {
                    @Override
                    public void onNext(BitmapHolder bitmapHolder) {
                        view.showMessage("Shared successfully");
                    }

                    @Override
                    public void onError(Throwable error) {
                        view.showError("Can't not download photo");
                    }

                    @Override
                    public void onCompleted() {
                        view.showProgress(false);
                    }
                }));
    }

    @Override
    public void savePhoto(String photoUrl) {
        view.showProgress(true);

        subscriptions.clear();
        subscriptions.add(imageDownloader.downloadBitmap(photoUrl)
                .observeOn(scheduler.main())
                .subscribeOn(scheduler.background())
                .subscribe(new Subscriber<BitmapHolder>() {
                    @Override
                    public void onNext(BitmapHolder bitmapHolder) {
                        view.showProgress(false);
                        view.showMessage("Saved successfully");
                    }

                    @Override
                    public void onError(Throwable error) {
                        view.showProgress(false);
                        view.showError("Can't not download photo");
                    }

                    @Override
                    public void onCompleted() {
                        view.showProgress(false);
                    }
                }));
    }

    @Override
    public void clearSubscriptions() {
        subscriptions.clear();
    }
}
