package com.alpsmobi.busroutes.dagger;

import com.alpsmobi.busroutes.activity.BusRoutesActivity;
import com.alpsmobi.busroutes.application.component.AppComponent;

import dagger.Component;

/**
 * Created by Prem on 11/5/2017.
 */

@BusRoutesScope
@Component(dependencies = {AppComponent.class} , modules = {BusRoutesModule.class})
public interface BusRoutesComponent {

    void inject (BusRoutesActivity busRoutesActivity);
}