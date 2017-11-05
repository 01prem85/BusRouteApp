package com.alpsmobi.busroutes.utils.reactive;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Prem on 11/5/2017.
 */

public class AppRxSchedulers implements RxSchedulers {

    private static Executor internetExecutor = Executors.newCachedThreadPool();
    public static Scheduler INTERNET_SCHEDULERS = Schedulers.from(internetExecutor);

    @Override
    public Scheduler mainThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler internet() {
        return INTERNET_SCHEDULERS;
    }
}
