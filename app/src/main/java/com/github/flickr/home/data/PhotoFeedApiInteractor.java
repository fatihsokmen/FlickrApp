package com.github.flickr.home.data;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import rx.Single;

public class PhotoFeedApiInteractor implements PhotoFeedInteractor {

    private final @NonNull PhotoFeedApiService apiService;
    private final @NonNull PhotoFeedDomainMapper mapper;

    @Inject
    PhotoFeedApiInteractor(@NonNull PhotoFeedApiService apiService,
                           @NonNull PhotoFeedDomainMapper mapper) {
        this.apiService = apiService;
        this.mapper = mapper;
    }

    public @NonNull Single<PhotoFeedDomain> getPhotos() {
        return apiService.getPhotos().map(mapper);
    }
}
