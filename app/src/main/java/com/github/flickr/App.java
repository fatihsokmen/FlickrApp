package com.github.flickr;

import android.app.Application;

public class App extends Application {

    private BaseAppComponent baseComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        baseComponent = DaggerAppComponent.builder()
                .application(this)
                .apiModule(new NetModule())
                .build();
    }

    public BaseAppComponent getBaseComponent() {
        return baseComponent;
    }
}
