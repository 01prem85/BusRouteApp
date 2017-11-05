package com.alpsmobi.busroutes.application.module;

import com.alpsmobi.busroutes.BuildConfig;
import com.alpsmobi.busroutes.api.BusRouteApi;
import com.alpsmobi.busroutes.application.configuration.AppScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Prem on 11/5/2017.
 */

@Module
public class BusRoutesServiceModule {

    @AppScope
    @Provides
    BusRouteApi provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJavaCallAdapterFactory rxAdapter)
    {
        Retrofit retrofit =   new Retrofit.Builder().client(client)
                .baseUrl(BuildConfig.BASE_URL).addConverterFactory(gson).
                        addCallAdapterFactory(rxAdapter).build();

        return  retrofit.create(BusRouteApi.class);
    }
}
