package com.github.flickr.scheduler;

import android.support.annotation.NonNull;

import rx.schedulers.Schedulers;

public class TestScheduler implements Scheduler {

    @Override
    public @NonNull rx.Scheduler background() {
        return Schedulers.immediate();
    }

    @Override
    public @NonNull rx.Scheduler main() {
        return Schedulers.immediate();
    }

    @Override
    public @NonNull rx.Scheduler immediate() {
        return Schedulers.immediate();
    }
}
