package com.github.flickr.home.viewholder;


import android.view.ViewGroup;

import com.github.flickr.home.viewholder.PhotoViewHolderModule.PhotoViewHolderLayoutModule;
import com.github.flickr.dependency.scope.ViewHolderScope;

import dagger.BindsInstance;
import dagger.Component;

@Component(
        modules = {
                PhotoViewHolderModule.class
        }
)
@ViewHolderScope
public interface PhotoViewHolderFactory {

    PhotoViewHolder createViewHolder();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder parentView(ViewGroup parentView);

        @BindsInstance
        Builder viewHolderInteractions(PhotoViewHolderContract.Interactions interactions);

        Builder layoutModule(PhotoViewHolderLayoutModule layoutModule);

        PhotoViewHolderFactory build();

    }
}