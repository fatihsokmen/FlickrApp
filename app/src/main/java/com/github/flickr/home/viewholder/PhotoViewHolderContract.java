package com.github.flickr.home.viewholder;

import com.github.flickr.home.data.PhotoFeedDomain;

public class PhotoViewHolderContract {

    public interface View {

        void setAuthorPhoto(String photo);

        void setAuthorName(String name);
    }

    public interface Presenter {

        void setView(View view);

        void bindData(PhotoFeedDomain.EntryDomain entry);
    }
}
