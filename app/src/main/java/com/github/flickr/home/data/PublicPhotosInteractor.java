package com.github.flickr.home.data;

import android.support.annotation.NonNull;

import rx.Observable;

public interface PublicPhotosInteractor {

    @NonNull Observable getPhotos();
}
