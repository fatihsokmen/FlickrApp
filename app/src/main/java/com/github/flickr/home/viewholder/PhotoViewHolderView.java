package com.github.flickr.home.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.flickr.R;
import com.github.flickr.home.data.PhotoFeedDomain;
import com.github.flickr.dependency.scope.LateInit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhotoViewHolderView extends PhotoViewHolder implements PhotoViewHolderContract.View {

    @BindView(R.id.user_name)
    TextView userNameView;
    @BindView(R.id.user_photo)
    ImageView userPhotoView;
    @BindView(R.id.image)
    ImageView imageView;
    @BindView(R.id.title)
    TextView titleView;

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
    public void setTitle(String title) {
        titleView.setText(title);
    }

    @Override
    public void setAuthorName(@NonNull String name) {
        userNameView.setText(name);
    }

    @Override
    public void setAuthorPhoto(@NonNull String photo) {
        Glide.with(itemView).load(photo).into(userPhotoView);
    }

    @Override
    public void setImageUrl(@NonNull String imageUrl) {
        Glide.with(itemView).load(imageUrl).into(imageView);
    }

    @OnClick(R.id.save_button)
    void onSavePhotoClicked() {
        presenter.onSavePhotoClicked();
    }

    @OnClick(R.id.share_button)
    void onSharePhotoClicked() {
        presenter.onSharePhotoClicked();
    }
}