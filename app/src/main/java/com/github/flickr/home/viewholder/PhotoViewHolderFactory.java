package com.github.flickr.home.viewholder;


import android.view.ViewGroup;

import com.github.flickr.scope.ViewHolderScope;

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

        Builder layoutModule(
                PhotoViewHolderModule.PhotoViewHolderLayoutModule viewHolderLayoutModule);

        PhotoViewHolderFactory build();

    }
}