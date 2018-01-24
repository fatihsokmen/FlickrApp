package com.github.flickr.home;

import android.support.annotation.NonNull;

import com.github.flickr.R;
import com.github.flickr.home.adapter.PhotoFeedAdapter;
import com.github.flickr.home.adapter.PhotoFeedAdapterContract;
import com.github.flickr.home.data.PhotoFeedApiInteractor;
import com.github.flickr.home.data.PhotoFeedInteractor;
import com.github.flickr.home.viewholder.DaggerPhotoViewHolderFactory;
import com.github.flickr.home.viewholder.PhotoViewHolderFactory;
import com.github.flickr.home.viewholder.PhotoViewHolderModule;
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


    @Provides
    @FragmentViewScope
    PhotoViewHolderFactory.Builder provideViewHolderFactory() {
        return DaggerPhotoViewHolderFactory
                .builder()
                .layoutModule(new PhotoViewHolderModule.PhotoViewHolderLayoutModule(
                        R.layout.view_feed_item));
    }

    @Module
    public interface Bindings {

        @Binds
        @FragmentViewScope
        HomeFragmentContract.Presenter provideFragmentPresenter(
                @NonNull HomeFragmentPresenter presenter);

        @Binds
        @FragmentViewScope
        PhotoFeedAdapterContract.View provideAdapterView(
                @NonNull PhotoFeedAdapter adapter);

        @Binds
        @FragmentViewScope
        PhotoFeedInteractor provideApiInteractor(PhotoFeedApiInteractor interactor);
    }

}
