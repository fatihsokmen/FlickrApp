package com.github.flickr.home.viewholder;

import android.support.annotation.NonNull;

import com.github.flickr.home.data.PhotoFeedDomain;

public class PhotoViewHolderContract {

    public interface View {

        void setAuthorPhoto(@NonNull String photo);

        void setAuthorName(@NonNull String name);

        void setImageUrl(@NonNull String imageUrl);

        void setTitle(String title);
    }

    public interface Presenter {

        void setView(View view);

        void bindData(PhotoFeedDomain.EntryDomain entry);
    }
}
