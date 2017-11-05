package com.alpsmobi.busroutes.utils.reactive;

import rx.Scheduler;

/**
 * Created by Prem on 11/5/2017.
 */

public interface RxSchedulers {

    Scheduler mainThread();
    Scheduler internet();

}
