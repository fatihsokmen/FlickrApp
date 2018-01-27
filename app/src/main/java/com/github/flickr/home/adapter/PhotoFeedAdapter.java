package com.github.flickr.home.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.github.flickr.home.HomeFragmentContract;
import com.github.flickr.home.data.PhotoFeedDomain;
import com.github.flickr.home.viewholder.PhotoViewHolder;
import com.github.flickr.home.viewholder.PhotoViewHolderFactory;

import java.util.List;

import javax.inject.Inject;

public class PhotoFeedAdapter extends RecyclerView.Adapter<PhotoViewHolder>
        implements PhotoFeedAdapterContract.View {

    private final @NonNull PhotoViewHolderFactory.Builder viewHolderFactoryBuilder;
    private final @NonNull PhotoFeedAdapterContract.Presenter presenter;

    @Inject
    PhotoFeedAdapter(@NonNull PhotoFeedAdapterContract.Presenter presenter,
                     @NonNull PhotoViewHolderFactory.Builder viewHolderFactoryBuilder) {
        this.presenter = presenter;
        this.viewHolderFactoryBuilder = viewHolderFactoryBuilder;
        presenter.setView(this);
    }

    public void bindData(List<PhotoFeedDomain.EntryDomain> entries) {
        presenter.setEntries(entries);
    }

    @Override
    public void onDataChanged() {
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewHolderFactoryBuilder.parentView(parent).build().createViewHolder();
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        holder.bind(presenter.get(position));
    }

    @Override
    public int getItemCount() {
        return presenter.getSize();
    }
}
