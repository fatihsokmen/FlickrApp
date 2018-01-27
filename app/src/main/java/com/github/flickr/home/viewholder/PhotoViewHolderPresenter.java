package com.github.flickr.home.viewholder;

import android.support.annotation.NonNull;

import com.github.flickr.home.data.PhotoFeedDomain;
import com.github.flickr.dependency.scope.LateInit;

import javax.inject.Inject;

public class PhotoViewHolderPresenter implements PhotoViewHolderContract.Presenter {

    private final @NonNull PhotoViewHolderContract.Interactions interactions;

    private @LateInit PhotoViewHolderContract.View view;

    private PhotoFeedDomain.EntryDomain entry;

    @Inject
    PhotoViewHolderPresenter(@NonNull PhotoViewHolderContract.Interactions interactions) {
        this.interactions = interactions;
    }

    public void setView(@NonNull PhotoViewHolderContract.View view) {
        this.view = view;
    }

    @Override
    public void bindData(@NonNull PhotoFeedDomain.EntryDomain entry) {
        this.entry = entry;
        view.setAuthorPhoto(entry.author.photo);
        view.setImageUrl(entry.imageUrl);
        view.setAuthorName(entry.author.name);
        view.setTitle(entry.title);
    }

    @Override
    public void onSavePhotoClicked() {
        interactions.onSavePhoto(entry.imageUrl);
    }

    @Override
    public void onSharePhotoClicked() {
        interactions.onSharePhoto(entry.imageUrl);
    }
}
