package com.github.flickr.dependency.scheduler;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SchedulerImpl implements Scheduler {

    @Inject
    SchedulerImpl() {
    }

    @Override
    public @NonNull rx.Scheduler background() {
        return Schedulers.io();
    }

    @Override
    public @NonNull rx.Scheduler main() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public @NonNull rx.Scheduler immediate() {
        return Schedulers.immediate();
    }
}
