package com.github.flickr;

import com.github.flickr.api.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        AppModule.class,
        ApiModule.class
})
@Singleton
public interface AppComponent extends BaseAppComponent {

    @Component.Builder
    interface Builder extends BaseAppComponent.Builder<AppComponent, Builder> {

    }
}
