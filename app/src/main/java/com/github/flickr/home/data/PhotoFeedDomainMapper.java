package com.github.flickr.home.data;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.functions.Func1;

import static com.github.flickr.home.data.PhotoFeedDTO.AuthorDTO;
import static com.github.flickr.home.data.PhotoFeedDTO.EntryDTO;
import static com.github.flickr.home.data.PhotoFeedDomain.AuthorDomain;
import static com.github.flickr.home.data.PhotoFeedDomain.EntryDomain;

public class PhotoFeedDomainMapper implements Func1<PhotoFeedDTO, PhotoFeedDomain> {

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

    private EntryDomain mapEntry(EntryDTO entryDTO) {
        return new EntryDomain(entryDTO.title, mapAuthor(entryDTO.author));
    }

    private AuthorDomain mapAuthor(AuthorDTO author) {
        return new AuthorDomain(author.name, author.buddyicon);
    }
}