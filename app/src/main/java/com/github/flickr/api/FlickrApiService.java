package com.github.flickr.api;

import com.github.flickr.home.data.PhotoFeedDTO;

import retrofit2.http.GET;
import rx.Single;

public interface FlickrApiService {

    @GET("feeds/photos_public.gne")
    Single<PhotoFeedDTO> getPhotos();
}
