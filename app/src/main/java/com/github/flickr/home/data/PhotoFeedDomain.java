package com.github.flickr.home.data;

import android.support.annotation.NonNull;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Collections;
import java.util.List;

public class PhotoFeedDomain {

    public final @NonNull List<EntryDomain> entries;

    PhotoFeedDomain(@NonNull List<EntryDomain> entries) {
        this.entries = Collections.unmodifiableList(entries);
    }

    public static class EntryDomain {

        public final @NonNull String title;
        public final @NonNull AuthorDomain author;

        EntryDomain(@NonNull String title,
                    @NonNull AuthorDomain author) {
            this.title = title;
            this.author = author;
        }
    }

    public static class AuthorDomain {

        public final @NonNull String name;
        public final @NonNull String photo;

        AuthorDomain(@NonNull String name,
                     @NonNull String photo) {
            this.name = name;
            this.photo = photo;
        }
    }
}


