package com.github.flickr.home.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.flickr.home.data.PhotoFeedDomain;

public abstract class PhotoViewHolder extends RecyclerView.ViewHolder {

    PhotoViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bind(@NonNull PhotoFeedDomain.EntryDomain entry);
}