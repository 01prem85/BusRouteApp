package com.alpsmobi.busroutes.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alpsmobi.busroutes.dagger.BusRouteDetailsModule;
import com.alpsmobi.busroutes.dagger.DaggerBusRouteDetailsComponent;
import com.alpsmobi.busroutes.model.BusRoute;
import com.alpsmobi.busroutes.view.BusRouteDetailsView;

import javax.inject.Inject;

public class BusRouteDetailActivity extends AppCompatActivity {

    @Inject
    BusRouteDetailsView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BusRoute busRoute = (BusRoute) getIntent().getExtras().get("busRoute");
        DaggerBusRouteDetailsComponent.builder().busRouteDetailsModule(new BusRouteDetailsModule(this, busRoute)).build().inject(this);
        setContentView(view.view());
    }
}
