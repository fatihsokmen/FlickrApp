package com.github.flickr.home.viewholder;

import android.support.annotation.NonNull;
import android.view.View;

import com.github.flickr.home.data.PhotoFeedDomain;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class PhotoViewHolderView extends PhotoViewHolder
        implements PhotoViewHolderContract.View {

    private final @NonNull PhotoViewHolderContract.Presenter presenter;

    @Inject
    PhotoViewHolderView(
            @NonNull View itemView,
            @NonNull PhotoViewHolderContract.Presenter presenter) {
        super(itemView);
        this.presenter = presenter;
        this.presenter.setView(this);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(@NonNull PhotoFeedDomain.EntryDomain entry) {
        presenter.bindData(entry);
    }

    @Override
    public void setAuthorName(String name) {

    }

    @Override
    public void setAuthorPhoto(String photo) {

    }
}