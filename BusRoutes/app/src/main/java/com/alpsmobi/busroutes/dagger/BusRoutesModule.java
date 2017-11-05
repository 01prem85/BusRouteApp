package com.alpsmobi.busroutes.dagger;

import com.alpsmobi.busroutes.activity.BusRoutesActivity;
import com.alpsmobi.busroutes.api.BusRouteApi;
import com.alpsmobi.busroutes.model.BusRoutesModel;
import com.alpsmobi.busroutes.presenter.BusRoutesPresenter;
import com.alpsmobi.busroutes.utils.reactive.RxSchedulers;
import com.alpsmobi.busroutes.view.BusRoutesView;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Prem on 11/5/2017.
 */

@Module
public class BusRoutesModule {

    BusRoutesActivity busRoutesListContext;

    public BusRoutesModule(BusRoutesActivity context) {
        this.busRoutesListContext = context;
    }

    @BusRoutesScope
    @Provides
    BusRoutesView provideView() {
        return new BusRoutesView(busRoutesListContext);
    }

    @BusRoutesScope
    @Provides
    BusRoutesPresenter providePresenter(RxSchedulers schedulers, BusRoutesView view, BusRoutesModel model) {
        CompositeSubscription subscriptions = new CompositeSubscription();
        return new BusRoutesPresenter(schedulers, model, view, subscriptions);
    }

    @BusRoutesScope
    @Provides
    BusRoutesActivity provideContext() {
        return busRoutesListContext;
    }

    @BusRoutesScope
    @Provides
    BusRoutesModel provideModel(BusRouteApi api) {
        return new BusRoutesModel(busRoutesListContext, api);
    }
}
