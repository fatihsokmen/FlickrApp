package com.github.flickr.home.data;

import retrofit2.http.GET;
import rx.Single;

public interface PhotoFeedApiService {

    @GET("feeds/photos_public.gne")
    Single<PhotoFeedDTO> getPhotos();
}
