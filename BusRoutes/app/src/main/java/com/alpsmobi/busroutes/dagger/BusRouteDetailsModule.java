package com.alpsmobi.busroutes.dagger;

import com.alpsmobi.busroutes.activity.BusRouteDetailActivity;
import com.alpsmobi.busroutes.model.BusRoute;
import com.alpsmobi.busroutes.view.BusRouteDetailsView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Prem on 11/5/2017.
 */

@Module
public class BusRouteDetailsModule {

    BusRouteDetailActivity detailsContext;
    BusRoute busRoute;

    public BusRouteDetailsModule(BusRouteDetailActivity context, BusRoute busRoute) {
        this.detailsContext = context;
        this.busRoute = busRoute;
    }

    @Provides
    BusRouteDetailsView provideView() {
        return  new BusRouteDetailsView(detailsContext,busRoute);
    }
}
