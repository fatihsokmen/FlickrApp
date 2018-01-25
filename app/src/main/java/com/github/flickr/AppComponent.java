package com.github.flickr;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        AppModule.class,
        NetModule.class
})
@Singleton
public interface AppComponent extends BaseAppComponent {

    @Component.Builder
    interface Builder extends BaseAppComponent.Builder<AppComponent, Builder> {

    }
}
