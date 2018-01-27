package com.github.flickr.dependency.download;

import android.support.annotation.NonNull;

import rx.Observable;

public interface ImageDownloader {

    @NonNull Observable<BitmapHolder> downloadBitmap(@NonNull String url);
}
