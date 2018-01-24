package com.github.flickr.home.data;

import android.support.annotation.NonNull;

import com.github.flickr.api.FlickrApi;

import javax.inject.Inject;

import rx.Observable;
import rx.Single;

public class PublicPhotosApiInteractor implements PublicPhotosInteractor {

    private final @NonNull FlickrApi flickrApi;

    @Inject
    PublicPhotosApiInteractor(@NonNull FlickrApi flickrApi) {
        this.flickrApi = flickrApi;
    }

    public @NonNull Observable getPhotos() {
        return flickrApi.getPhotos();
    }
}
