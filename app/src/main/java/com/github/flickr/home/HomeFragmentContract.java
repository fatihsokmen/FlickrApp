package com.github.flickr.home;

import android.support.annotation.NonNull;

import com.github.flickr.home.data.PhotoFeedDomain;

import java.util.List;

public interface HomeFragmentContract {

    interface View {

        void showProgress(boolean show);

        void bindData(@NonNull List<PhotoFeedDomain.EntryDomain> entries);
    }

    interface Presenter {

        void init();

        void clearSubscriptions();
    }
}
