package com.github.flickr.home.adapter;

import com.flextrade.jfixture.FixtureAnnotations;
import com.flextrade.jfixture.JFixture;
import com.flextrade.jfixture.utility.SpecimenType;
import com.github.flickr.home.data.PhotoFeedDomain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.verify;

public class PhotoFeedAdapterPresenterTest {

    private static final SpecimenType<List<PhotoFeedDomain.EntryDomain>> DOMAIN_SPECIMEN =
            new SpecimenType<List<PhotoFeedDomain.EntryDomain>>() {
            };

    @Mock PhotoFeedAdapterContract.View mockView;

    private PhotoFeedAdapterPresenter sut;
    private JFixture fixture;

    @Before
    public void setUp() {
        FixtureAnnotations.initFixtures(this, fixture = new JFixture());
        sut = new PhotoFeedAdapterPresenter();
        sut.setView(mockView);
    }

    @Test
    public void setEntries() {
        List<PhotoFeedDomain.EntryDomain> fixtEntries = fixture.create(DOMAIN_SPECIMEN);

        sut.setEntries(fixtEntries);

        verify(mockView).onDataChanged();
    }
}
