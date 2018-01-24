package com.github.flickr.home.adapter;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

import com.github.flickr.home.data.PhotoFeedDomain;

import java.util.List;

public class PhotoFeedAdapterContract {

    public interface View {

        void onDataChanged();
    }

    public interface Presenter {

        void setView(@NonNull View view);

        void setEntries(@NonNull List<PhotoFeedDomain.EntryDomain> entries);
        
        @IntRange(from = 0) int getSize();

        @NonNull PhotoFeedDomain.EntryDomain get(int position);
    }
}
