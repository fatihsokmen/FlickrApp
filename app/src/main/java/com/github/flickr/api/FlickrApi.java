package com.github.flickr.api;

import retrofit2.http.GET;
import rx.Observable;

public interface FlickrApi {

    @GET("feeds/photos_public.gne?format=json")
    Observable getPhotos();
}
