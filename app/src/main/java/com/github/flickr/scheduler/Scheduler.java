package com.github.flickr.scheduler;

import android.support.annotation.NonNull;

public interface Scheduler {

    @NonNull rx.Scheduler background();

    @NonNull rx.Scheduler main();
}