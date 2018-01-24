package com.github.flickr.home.data;

import android.support.annotation.NonNull;

import rx.Single;

public interface PhotoFeedInteractor {

    @NonNull Single<PhotoFeedDomain> getPhotos();
}