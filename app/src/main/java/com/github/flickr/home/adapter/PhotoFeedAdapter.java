package com.github.flickr.home.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.github.flickr.home.data.PhotoFeedDomain;
import com.github.flickr.home.viewholder.PhotoViewHolder;
import com.github.flickr.home.viewholder.PhotoViewHolderFactory;
import com.github.flickr.scope.LateInit;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class PhotoFeedAdapter extends RecyclerView.Adapter<PhotoViewHolder>
        implements PhotoFeedAdapterContract.View {

    private final @NonNull
    PhotoViewHolderFactory.Builder viewHolderFactoryBuilder;

    private @LateInit PhotoFeedAdapterContract.Presenter presenter;
    private List<PhotoFeedDomain.EntryDomain> entries = Collections.emptyList();

    @Inject
    PhotoFeedAdapter(@NonNull PhotoViewHolderFactory.Builder viewHolderFactoryBuilder) {
        this.viewHolderFactoryBuilder = viewHolderFactoryBuilder;
    }

    @Override
    public void setPresenter(@NonNull PhotoFeedAdapterContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void bindData(List<PhotoFeedDomain.EntryDomain> entries) {
        this.entries = entries;
        this.notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewHolderFactoryBuilder.parentView(parent).build().createViewHolder();
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        holder.bind(entries.get(position));
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }
}
