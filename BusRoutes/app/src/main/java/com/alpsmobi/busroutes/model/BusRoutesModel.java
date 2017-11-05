package com.alpsmobi.busroutes.model;

import com.alpsmobi.busroutes.activity.BusRoutesActivity;
import com.alpsmobi.busroutes.api.BusRouteApi;
import com.alpsmobi.busroutes.utils.NetworkUtils;

import rx.Observable;

/**
 * Created by Prem on 11/5/2017.
 */

public class BusRoutesModel {

    BusRoutesActivity context;
    BusRouteApi api;

    public BusRoutesModel(BusRoutesActivity context, BusRouteApi api) {
        this.api = api;
        this.context = context;
    }

    public Observable<BusRoutes> provideListBusRoutes() {
        return api.getBusRoutes();
    }

    public Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(context);
    }

    public void goToBusRouteDetailActivity(BusRoute busRoute) {
        context.goToBusRouteDetailActivity(busRoute);
    }

    public void showAlertMessage(String message) {
        context.showSnackBar(message);
    }

}
