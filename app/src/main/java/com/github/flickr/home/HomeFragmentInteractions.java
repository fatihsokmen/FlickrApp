package com.github.flickr.home;


import android.support.annotation.NonNull;

import javax.inject.Inject;

public class HomeFragmentInteractions implements HomeFragmentContract.Interactions {

    private final @NonNull HomeFragmentContract.Presenter homePresenter;

    @Inject
    HomeFragmentInteractions(@NonNull HomeFragmentContract.Presenter homePresenter) {
        this.homePresenter = homePresenter;
    }

    @Override
    public void onSharePhoto(@NonNull String photoUrl) {
        homePresenter.sharePhoto(photoUrl);
    }

    @Override
    public void onSavePhoto(@NonNull String photoUrl) {
        homePresenter.savePhoto(photoUrl);
    }
}
