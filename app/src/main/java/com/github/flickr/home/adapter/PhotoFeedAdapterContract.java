package com.github.flickr.home.adapter;

import android.support.annotation.NonNull;

public class PhotoFeedAdapterContract {

    public interface View {

        void setPresenter(@NonNull Presenter presenter);
    }

    public interface Presenter {

    }
}
