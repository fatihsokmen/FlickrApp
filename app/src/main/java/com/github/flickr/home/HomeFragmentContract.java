package com.github.flickr.home;

import android.support.annotation.NonNull;

import com.github.flickr.home.data.PhotoFeedDomain;
import com.github.flickr.home.viewholder.PhotoViewHolderContract;

import java.util.List;

public interface HomeFragmentContract {

    interface View {

        void showProgress(boolean show);

        void showError(@NonNull String message);

        void showMessage(@NonNull String message);

        void bindData(@NonNull List<PhotoFeedDomain.EntryDomain> entries);
    }

    interface Presenter {

        void init();

        void clearSubscriptions();

        void sharePhoto(String photoUrl);

        void savePhoto(String photoUrl);
    }

    interface Interactions extends PhotoViewHolderContract.Interactions {
    }
}
