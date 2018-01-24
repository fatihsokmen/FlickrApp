package com.github.flickr;

import android.app.Application;

import com.github.flickr.api.ApiModule;

public class App extends Application {

    private BaseAppComponent baseComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        baseComponent = DaggerAppComponent.builder()
                .application(this)
                .apiModule(new ApiModule())
                .build();
    }

    public BaseAppComponent getBaseComponent() {
        return baseComponent;
    }
}
