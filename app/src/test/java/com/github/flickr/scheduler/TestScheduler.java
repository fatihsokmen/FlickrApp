package com.github.flickr.scheduler;

import com.github.flickr.scheduler.Scheduler;

import rx.schedulers.Schedulers;

public class TestScheduler implements Scheduler {

    @Override
    public rx.Scheduler background() {
        return Schedulers.immediate();
    }

    @Override
    public rx.Scheduler main() {
        return Schedulers.immediate();
    }

    @Override
    public rx.Scheduler immediate() {
        return Schedulers.immediate();
    }
}
