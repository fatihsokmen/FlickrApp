package com.github.flickr.dependency;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        AppModule.class,
        NetModule.class,
        DownloadModule.class
})
@Singleton
public interface AppComponent extends BaseAppComponent {

    @Component.Builder
    interface Builder extends BaseAppComponent.Builder<AppComponent, Builder> {

    }
}
