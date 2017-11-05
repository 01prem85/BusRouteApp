package com.alpsmobi.busroutes.application;

import android.app.Application;

import com.alpsmobi.busroutes.application.component.AppComponent;
import com.alpsmobi.busroutes.application.component.DaggerAppComponent;
import com.alpsmobi.busroutes.application.module.AppContextModule;

/**
 * Created by Prem on 11/5/2017.
 */

public class AppController extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();
    }

    public static AppComponent getNetComponent() {
        return appComponent;
    }
}
