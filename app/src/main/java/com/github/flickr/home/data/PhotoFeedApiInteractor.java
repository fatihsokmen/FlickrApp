package com.github.flickr.home.data;

import android.support.annotation.NonNull;

import com.github.flickr.api.FlickrApiService;

import javax.inject.Inject;

import rx.Observable;
import rx.Single;

public class PhotoFeedApiInteractor implements PhotoFeedInteractor {

    private final @NonNull
    FlickrApiService flickrApi;

    @Inject
    PhotoFeedApiInteractor(@NonNull FlickrApiService flickrApi) {
        this.flickrApi = flickrApi;
    }

    public @NonNull
    Single<PhotoFeedDTO> getPhotos() {
        return flickrApi.getPhotos();
    }
}
