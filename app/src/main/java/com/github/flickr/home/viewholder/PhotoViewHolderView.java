package com.github.flickr.home.viewholder;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.flickr.R;
import com.github.flickr.home.data.PhotoFeedDomain;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoViewHolderView extends PhotoViewHolder
        implements PhotoViewHolderContract.View {

    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.user_photo)
    ImageView userPhoto;
    @BindView(R.id.image)
    ImageView image;

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
        userName.setText(name);
    }

    @Override
    public void setAuthorPhoto(String photo) {
        Glide.with(itemView).load(photo).into(userPhoto);
    }
}