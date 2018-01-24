package com.github.flickr.home.viewholder;

import android.support.annotation.NonNull;

import com.github.flickr.home.data.PhotoFeedDomain;
import com.github.flickr.scope.LateInit;

import javax.inject.Inject;

public class PhotoViewHolderPresenter implements PhotoViewHolderContract.Presenter {

    private @LateInit PhotoViewHolderContract.View view;

    @Inject
    PhotoViewHolderPresenter() {
    }

    public void setView(@NonNull PhotoViewHolderContract.View view) {
        this.view = view;
    }

    @Override
    public void bindData(PhotoFeedDomain.EntryDomain entry) {
        view.setAuthorPhoto(entry.author.photo);
        view.setAuthorName(entry.author.name);
    }
}
