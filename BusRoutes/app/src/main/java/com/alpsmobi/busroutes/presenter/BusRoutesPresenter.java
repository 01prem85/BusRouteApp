package com.alpsmobi.busroutes.presenter;

import android.util.Log;

import com.alpsmobi.busroutes.model.BusRoute;
import com.alpsmobi.busroutes.model.BusRoutesModel;
import com.alpsmobi.busroutes.utils.reactive.RxSchedulers;
import com.alpsmobi.busroutes.view.BusRoutesView;

import java.util.ArrayList;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Prem on 11/5/2017.
 */

public class BusRoutesPresenter {

    BusRoutesView view;
    BusRoutesModel model;
    RxSchedulers rxSchedulers;
    CompositeSubscription subscriptions;
    ArrayList<BusRoute> busRoutes = new ArrayList<>();

    public BusRoutesPresenter(RxSchedulers schedulers, BusRoutesModel model, BusRoutesView view, CompositeSubscription sub) {
        this.rxSchedulers = schedulers;
        this.view = view;
        this.model = model;
        this.subscriptions = sub;
    }

    public void onCreate() {
        subscriptions.add(getBusRoutesList());
        subscriptions.add(respondToClick());
    }

    public void onDestroy() {
        subscriptions.clear();
    }

    private Subscription respondToClick() {
        return view.itemClicks().subscribe(integer -> model.goToBusRouteDetailActivity(busRoutes.get(integer)));
    }

    private Subscription getBusRoutesList() {

        return model.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                Log.d("no conn", "no connexion");
                model.showAlertMessage("No internet connection !!!");
            }
        }).
                filter(isNetworkAvailable -> true).
                flatMap(isAvailable -> model.provideListBusRoutes()).
                subscribeOn(rxSchedulers.internet()).
                observeOn(rxSchedulers.mainThread()).subscribe(busRoutesAction -> {
                    view.swapAdapter((ArrayList<BusRoute>) busRoutesAction.getRoutes());
                    busRoutes = (ArrayList<BusRoute>) busRoutesAction.getRoutes();
                }, throwable -> {
                    model.showAlertMessage(throwable.getMessage());
                }
        );

    }
}
