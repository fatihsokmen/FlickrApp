package com.github.flickr.home.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "feed", strict = false)
public class PhotoFeedDTO {

    @ElementList(inline = true)
    public List<EntryDTO> entries;

    @Root(name = "entry", strict = false)
    public static class EntryDTO {
        @Element
        public String title;
        @Element
        public ContentDTO content;
        @Element(required = false)
        public AuthorDTO author;
        @Element(required = false)
        public String link;
    }

    @Root(name = "content", strict = false)
    public static class ContentDTO {
    }

    @Root(name = "author", strict = false)
    public static class AuthorDTO {
        @Element
        public String name;
        @Element
        public String buddyicon;
    }
}


