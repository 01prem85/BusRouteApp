package com.alpsmobi.busroutes.api;

import com.alpsmobi.busroutes.BuildConfig;
import com.alpsmobi.busroutes.model.BusRoutes;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Prem on 11/5/2017.
 */

public interface BusRouteApi {

    @GET(BuildConfig.EXT)
    Observable<BusRoutes> getBusRoutes();
}
