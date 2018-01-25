package com.github.flickr.home.data;


import android.support.annotation.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.functions.Func1;

import static com.github.flickr.home.data.PhotoFeedDTO.AuthorDTO;
import static com.github.flickr.home.data.PhotoFeedDTO.EntryDTO;
import static com.github.flickr.home.data.PhotoFeedDomain.AuthorDomain;
import static com.github.flickr.home.data.PhotoFeedDomain.EntryDomain;

public class PhotoFeedDomainMapper implements Func1<PhotoFeedDTO, PhotoFeedDomain> {

    @VisibleForTesting
    static final String IMAGE_JPEG = "image/jpeg";

    @VisibleForTesting
    static final String TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

    @Inject
    PhotoFeedDomainMapper() {
    }

    @Override
    public PhotoFeedDomain call(PhotoFeedDTO photoFeedDTO) {
        List<PhotoFeedDomain.EntryDomain> entryDomains = new ArrayList<>();
        for (EntryDTO entryDTO : photoFeedDTO.entries) {
            entryDomains.add(mapEntry(entryDTO));
        }
        return new PhotoFeedDomain(entryDomains);
    }

    @VisibleForTesting
    EntryDomain mapEntry(EntryDTO entryDTO) {
        return new EntryDomain(entryDTO.title, mapUrl(entryDTO.links), mapAuthor(entryDTO.author));
    }

    @VisibleForTesting
    AuthorDomain mapAuthor(AuthorDTO author) {
        return new AuthorDomain(author.name, author.buddyicon);
    }

    @VisibleForTesting
    String mapUrl(List<PhotoFeedDTO.LinkDTO> links) {
        for (PhotoFeedDTO.LinkDTO linkDTO : links) {
            if (IMAGE_JPEG.equalsIgnoreCase(linkDTO.type)) {
                return linkDTO.href;
            }
        }
        return null;
    }
}
