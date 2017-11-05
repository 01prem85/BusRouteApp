package com.alpsmobi.busroutes.application.component;

import com.alpsmobi.busroutes.api.BusRouteApi;
import com.alpsmobi.busroutes.application.configuration.AppScope;
import com.alpsmobi.busroutes.application.module.AppContextModule;
import com.alpsmobi.busroutes.application.module.BusRoutesServiceModule;
import com.alpsmobi.busroutes.application.module.NetworkModule;
import com.alpsmobi.busroutes.application.module.RxModule;
import com.alpsmobi.busroutes.utils.reactive.RxSchedulers;

import dagger.Component;

/**
 * Created by Prem on 11/5/2017.
 */

@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, BusRoutesServiceModule.class})
public interface AppComponent {

    RxSchedulers rxSchedulers();
    BusRouteApi apiService();

}
