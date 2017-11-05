package com.alpsmobi.busroutes.dagger;

import com.alpsmobi.busroutes.activity.BusRouteDetailActivity;

import dagger.Component;

/**
 * Created by Prem on 11/5/2017.
 */

@Component(modules = {BusRouteDetailsModule.class})
public interface BusRouteDetailsComponent {
    void inject(BusRouteDetailActivity context);
}
