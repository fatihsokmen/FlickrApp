package com.github.flickr.home.data;

import android.support.annotation.NonNull;

import com.github.flickr.api.FlickrApiService;

import javax.inject.Inject;

import rx.Observable;
import rx.Single;
import rx.functions.Func1;

public class PhotoFeedApiInteractor implements PhotoFeedInteractor {

    private final @NonNull FlickrApiService flickrApi;
    private final @NonNull PhotoFeedDomainMapper mapper;

    @Inject
    PhotoFeedApiInteractor(@NonNull FlickrApiService flickrApi,
                           @NonNull PhotoFeedDomainMapper mapper) {
        this.flickrApi = flickrApi;
        this.mapper = mapper;
    }

    public @NonNull Single<PhotoFeedDomain> getPhotos() {
        return flickrApi.getPhotos().map(mapper);
    }
}
