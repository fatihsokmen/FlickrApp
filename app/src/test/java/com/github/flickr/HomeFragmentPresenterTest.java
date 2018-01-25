package com.github.flickr;

import com.flextrade.jfixture.FixtureAnnotations;
import com.flextrade.jfixture.annotations.Fixture;
import com.github.flickr.home.HomeFragmentContract;
import com.github.flickr.home.HomeFragmentPresenter;
import com.github.flickr.home.data.PhotoFeedDomain;
import com.github.flickr.home.data.PhotoFeedInteractor;
import com.github.flickr.scheduler.TestScheduler;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Single;
import rx.subjects.PublishSubject;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HomeFragmentPresenterTest {

    @Mock
    HomeFragmentContract.View mockView;
    @Mock
    PhotoFeedInteractor mockApiInteractor;

    @Fixture
    PhotoFeedDomain fixtFeedDomain;

    private HomeFragmentPresenter sut;

    @Before
    public void setUp() {
        FixtureAnnotations.initFixtures(this);
        MockitoAnnotations.initMocks(this);
        sut = new HomeFragmentPresenter(mockView, mockApiInteractor, new TestScheduler());
    }

    @Test
    public void initWhenSuccessful() {
        PublishSubject<PhotoFeedDomain> subject = PublishSubject.create();
        when(mockApiInteractor.getPhotos()).thenReturn(subject.toSingle());

        sut.init();
        subject.onNext(fixtFeedDomain);
        subject.onCompleted();

        verify(mockView).bindData(fixtFeedDomain.entries);
        verify(mockView).showProgress(false);
    }

    @Test
    public void initWhenError() {
        when(mockApiInteractor.getPhotos()).thenReturn(Single.<PhotoFeedDomain>error(
                new Throwable("unexpected exception")));

        sut.init();

        verify(mockView).showProgress(false);
    }
}
