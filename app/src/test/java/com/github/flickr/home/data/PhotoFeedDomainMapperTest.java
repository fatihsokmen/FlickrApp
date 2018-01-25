package com.github.flickr.home.data;

import com.flextrade.jfixture.FixtureAnnotations;
import com.flextrade.jfixture.JFixture;
import com.flextrade.jfixture.annotations.Fixture;
import com.flextrade.jfixture.utility.SpecimenType;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.github.flickr.home.data.PhotoFeedDomainMapper.IMAGE_JPEG;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class PhotoFeedDomainMapperTest {

    private static final SpecimenType<List<PhotoFeedDomain.EntryDomain>> DOMAIN_SPECIMEN =
            new SpecimenType<List<PhotoFeedDomain.EntryDomain>>() {
            };

    @Fixture PhotoFeedDTO fixtDTO;

    private PhotoFeedDomainMapper sut;
    private JFixture fixture;

    @Before
    public void setUp() {
        FixtureAnnotations.initFixtures(this, fixture = new JFixture());
        sut = new PhotoFeedDomainMapper();
    }

    @Test
    public void map() {
        PhotoFeedDomainMapper spySut = spy(sut);

        List<PhotoFeedDomain.EntryDomain> fixtFeedDomains = fixture.create(DOMAIN_SPECIMEN);

        int i = 0;
        for (PhotoFeedDTO.EntryDTO entryDTO : fixtDTO.entries) {
            doReturn(fixtFeedDomains.get(i)).when(spySut).mapEntry(entryDTO);
            i++;
        }

        PhotoFeedDomain actual = spySut.call(fixtDTO);

        assertEquals(actual.entries.get(0), fixtFeedDomains.get(0));
        assertEquals(actual.entries.get(1), fixtFeedDomains.get(1));
        assertEquals(actual.entries.get(2), fixtFeedDomains.get(2));
    }

    @Test
    public void mapEntity() {
        PhotoFeedDomainMapper spySut = spy(sut);

        PhotoFeedDTO.EntryDTO fixtEntryDTO = fixture.create(PhotoFeedDTO.EntryDTO.class);
        PhotoFeedDomain.AuthorDomain fixtAuthorDomain = fixture.create(PhotoFeedDomain.AuthorDomain.class);

        doReturn(fixtAuthorDomain).when(spySut).mapAuthor(fixtEntryDTO.author);

        String fixtImageUrl = fixture.create(String.class);
        doReturn(fixtImageUrl).when(spySut).mapUrl(fixtEntryDTO.links);

        PhotoFeedDomain.EntryDomain actual =  spySut.mapEntry(fixtEntryDTO);

        assertEquals(fixtEntryDTO.title, actual.title);
        assertEquals(fixtAuthorDomain, actual.author);
    }

    @Test
    public void mapAuthor() {
        PhotoFeedDTO.AuthorDTO fixtAuthorDTO = fixture.create(PhotoFeedDTO.AuthorDTO.class);

        PhotoFeedDomain.AuthorDomain actual =  sut.mapAuthor(fixtAuthorDTO);

        assertEquals(fixtAuthorDTO.name, actual.name);
        assertEquals(fixtAuthorDTO.buddyicon, actual.photo);
    }

    @Test
    public void mapUrl() {
        PhotoFeedDTO.LinkDTO fixtLink1DTO = fixture.create(PhotoFeedDTO.LinkDTO.class);
        fixtLink1DTO.type = IMAGE_JPEG;
        PhotoFeedDTO.LinkDTO fixtLink2DTO = fixture.create(PhotoFeedDTO.LinkDTO.class);

        String actual =  sut.mapUrl(Arrays.asList(fixtLink1DTO, fixtLink2DTO));

        assertEquals(fixtLink1DTO.href, actual);
    }
}
