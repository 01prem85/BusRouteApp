package com.alpsmobi.busroutes.application.module;

import android.content.Context;

import com.alpsmobi.busroutes.application.configuration.AppScope;
import com.alpsmobi.busroutes.utils.reactive.AppRxSchedulers;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Prem on 11/5/2017.
 */

@Module
public class NetworkModule {

    private static final int maxSize = 10 * 10 * 1000;

    @AppScope
    @Provides
    OkHttpClient provideHttpClient(Cache cache) {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.cache(cache);
        return builder.build();
    }

    @AppScope
    @Provides
    Cache provideCache(File file) {
        return new Cache(file, maxSize);
    }

    @AppScope
    @Provides
    File provideCacheFile(Context context) {
        return context.getFilesDir();
    }

    @AppScope
    @Provides
    RxJavaCallAdapterFactory provideRxAdapter() {
        return RxJavaCallAdapterFactory.createWithScheduler(AppRxSchedulers.INTERNET_SCHEDULERS);
    }

    @Provides
    GsonConverterFactory provideGsonClient() {
        return GsonConverterFactory.create();
    }
}
