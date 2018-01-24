package com.github.flickr.home;

import com.github.flickr.BaseAppComponent;
import com.github.flickr.scope.FragmentViewScope;

import dagger.Component;

@Component(
        dependencies = {
                BaseAppComponent.class
        },
        modules = {
                HomeFragmentModule.class
        }
)
@FragmentViewScope
public interface HomeFragmentComponent {

    void inject(HomeFragment fragment);
}