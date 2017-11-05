package com.alpsmobi.busroutes.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;

import com.alpsmobi.busroutes.application.AppController;
import com.alpsmobi.busroutes.dagger.BusRoutesModule;
import com.alpsmobi.busroutes.dagger.DaggerBusRoutesComponent;
import com.alpsmobi.busroutes.model.BusRoute;
import com.alpsmobi.busroutes.presenter.BusRoutesPresenter;
import com.alpsmobi.busroutes.view.BusRoutesView;

import java.io.Serializable;

import javax.inject.Inject;

public class BusRoutesActivity extends Activity {

    @Inject
    BusRoutesView view;
    @Inject
    BusRoutesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerBusRoutesComponent.builder().appComponent(AppController.getNetComponent()).busRoutesModule(new BusRoutesModule(this)).build().inject(this);
        setContentView(view.view());
        presenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public void goToBusRouteDetailActivity(BusRoute busRoute) {
        Intent in = new Intent(this, BusRouteDetailActivity.class);
        in.putExtra("busRoute", (Serializable) busRoute);
        startActivity(in);
    }

    public void showSnackBar(String message){
        Snackbar.make(this.getWindow().getDecorView(),  message, Snackbar.LENGTH_LONG).show();
    }
}
