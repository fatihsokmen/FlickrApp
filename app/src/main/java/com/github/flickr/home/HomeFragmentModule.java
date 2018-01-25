package com.github.flickr.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

import com.github.flickr.R;
import com.github.flickr.home.data.PhotoFeedApiService;
import com.github.flickr.home.adapter.PhotoFeedAdapter;
import com.github.flickr.home.adapter.PhotoFeedAdapterContract;
import com.github.flickr.home.adapter.PhotoFeedAdapterPresenter;
import com.github.flickr.home.data.PhotoFeedApiInteractor;
import com.github.flickr.home.data.PhotoFeedInteractor;
import com.github.flickr.home.viewholder.DaggerPhotoViewHolderFactory;
import com.github.flickr.home.viewholder.PhotoViewHolderFactory;
import com.github.flickr.home.viewholder.PhotoViewHolderModule;
import com.github.flickr.scope.FragmentViewScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

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
    PhotoFeedApiService provideApiService(@NonNull Retrofit retrofit) {
        return retrofit.create(PhotoFeedApiService.class);
    }

    @Provides
    @FragmentViewScope
    PhotoViewHolderFactory.Builder provideViewHolderFactory() {
        return DaggerPhotoViewHolderFactory
                .builder()
                .layoutModule(new PhotoViewHolderModule.PhotoViewHolderLayoutModule(
                        R.layout.view_feed_item));
    }

    @Provides
    @FragmentViewScope
    RecyclerView.ItemDecoration provideItemDecoration(@NonNull Context context) {
        DividerItemDecoration itemDecoration = new DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL);
        //noinspection ConstantConditions
        itemDecoration.setDrawable(ContextCompat.getDrawable(context, R.drawable.elevated_list_divider));
        return itemDecoration;
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
        PhotoFeedAdapterContract.Presenter provideAdapterPresenter(
                @NonNull PhotoFeedAdapterPresenter presenter);

        @Binds
        @FragmentViewScope
        PhotoFeedInteractor provideApiInteractor(PhotoFeedApiInteractor interactor);
    }

}
