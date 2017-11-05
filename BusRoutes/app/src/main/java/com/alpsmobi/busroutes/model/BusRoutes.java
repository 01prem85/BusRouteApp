package com.alpsmobi.busroutes.model;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by Prem on 11/5/2017.
 */

public class BusRoutes {

    @Expose
    private List<BusRoute> routes;

    public List<BusRoute> getRoutes() {
        return routes;
    }

    public void setRoutes(List<BusRoute> routes) {
        this.routes = routes;
    }
}
