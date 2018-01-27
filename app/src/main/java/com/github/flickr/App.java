package com.github.flickr;

import android.app.Application;

import com.github.flickr.dependency.BaseAppComponent;
import com.github.flickr.dependency.DaggerAppComponent;
import com.github.flickr.dependency.DownloadModule;
import com.github.flickr.dependency.NetModule;

public class App extends Application {

    private BaseAppComponent baseComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        baseComponent = DaggerAppComponent.builder()
                .application(this)
                .apiModule(new NetModule())
                .downloadModule(new DownloadModule())
                .build();
    }

    public BaseAppComponent getBaseComponent() {
        return baseComponent;
    }
}
