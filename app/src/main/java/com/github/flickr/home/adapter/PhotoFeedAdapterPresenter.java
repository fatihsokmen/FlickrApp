package com.github.flickr.home.adapter;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

import com.github.flickr.home.data.PhotoFeedDomain;
import com.github.flickr.dependency.scope.LateInit;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class PhotoFeedAdapterPresenter implements PhotoFeedAdapterContract.Presenter {

    private @NonNull List<PhotoFeedDomain.EntryDomain> entries = Collections.emptyList();

    private @LateInit PhotoFeedAdapterContract.View view;

    @Inject
    PhotoFeedAdapterPresenter() {
    }

    @Override
    public void setView(@NonNull PhotoFeedAdapterContract.View view) {
        this.view = view;
    }

    @Override
    public void setEntries(@NonNull List<PhotoFeedDomain.EntryDomain> entries) {
        this.entries = entries;
        view.onDataChanged();
    }

    @Override
    public @IntRange(from = 0) int getSize() {
        return entries.size();
    }

    @Override
    public @NonNull PhotoFeedDomain.EntryDomain get(int position) {
        return entries.get(position);
    }
}
