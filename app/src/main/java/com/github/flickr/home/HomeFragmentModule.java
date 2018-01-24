package com.github.flickr.home;

import android.support.annotation.NonNull;

import com.github.flickr.home.data.PhotoFeedApiInteractor;
import com.github.flickr.home.data.PhotoFeedInteractor;
import com.github.flickr.scope.FragmentViewScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module(includes = {
        HomeFragmentModule.Bindings.class
})
class HomeFragmentModule {

    private final @NonNull HomeFragmentContract.View view;

    HomeFragmentModule(@NonNull HomeFragmentContract.View view) {
        this.view = view;
    }

    @Provides
    @FragmentViewScope
    HomeFragmentContract.View provideView() {
        return view;
    }


    @Module
    public interface Bindings {

        @Binds
        @FragmentViewScope
        HomeFragmentContract.Presenter provideFragmentPresenter(
                HomeFragmentPresenter presenter);

        @Binds
        @FragmentViewScope
        PhotoFeedInteractor provideApiInteractor(
                PhotoFeedApiInteractor interactor);
    }
}
