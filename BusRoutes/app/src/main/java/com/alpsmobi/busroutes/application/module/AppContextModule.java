package com.alpsmobi.busroutes.application.module;

import android.content.Context;

import com.alpsmobi.busroutes.application.configuration.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Prem on 11/5/2017.
 */

@Module
public class AppContextModule {

    private final Context context;

    public AppContextModule(Context aContext) {
        this.context = aContext;
    }

    @AppScope
    @Provides
    Context provideAppContext() {
        return context;
    }
}
