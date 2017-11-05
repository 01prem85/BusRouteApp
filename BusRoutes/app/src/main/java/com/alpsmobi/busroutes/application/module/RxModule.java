package com.alpsmobi.busroutes.application.module;

import com.alpsmobi.busroutes.utils.reactive.AppRxSchedulers;
import com.alpsmobi.busroutes.utils.reactive.RxSchedulers;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Prem on 11/5/2017.
 */

@Module
public class RxModule {

    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }
}