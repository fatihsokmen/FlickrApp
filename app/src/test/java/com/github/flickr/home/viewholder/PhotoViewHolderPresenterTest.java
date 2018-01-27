package com.github.flickr.home.viewholder;


import com.flextrade.jfixture.FixtureAnnotations;
import com.flextrade.jfixture.JFixture;
import com.github.flickr.home.data.PhotoFeedDomain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class PhotoViewHolderPresenterTest {

    private @Mock PhotoViewHolderContract.View mockView;
    private @Mock PhotoViewHolderContract.Interactions mockInteractions;

    private PhotoViewHolderPresenter sut;
    private JFixture fixture;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        FixtureAnnotations.initFixtures(this, fixture = new JFixture());
        sut = new PhotoViewHolderPresenter(mockInteractions);
        sut.setView(mockView);
    }

    @Test
    public void bindData() {
        PhotoFeedDomain.EntryDomain fixtEntry = fixture.create(PhotoFeedDomain.EntryDomain.class);
        sut.bindData(fixtEntry);

        verify(mockView).setAuthorPhoto(fixtEntry.author.photo);
        verify(mockView).setImageUrl(fixtEntry.imageUrl);
        verify(mockView).setAuthorName(fixtEntry.author.name);
        verify(mockView).setTitle(fixtEntry.title);
    }
}
