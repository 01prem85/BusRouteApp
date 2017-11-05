package com.alpsmobi.busroutes.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.alpsmobi.busroutes.R;
import com.alpsmobi.busroutes.activity.BusRoutesActivity;
import com.alpsmobi.busroutes.activity.adapter.BusRoutesAdapter;
import com.alpsmobi.busroutes.model.BusRoute;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

/**
 * Created by Prem on 11/5/2017.
 */

public class BusRoutesView {

    @BindView(R.id.activity_bus_routes_recycleview)
    RecyclerView list;
    BusRoutesAdapter adapter;
    View view;

    public BusRoutesView(BusRoutesActivity context ) {
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_bus_routes, parent, true);
        ButterKnife.bind(this, view);

        adapter = new BusRoutesAdapter();

        list.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        list.setLayoutManager(mLayoutManager);
    }

    public Observable<Integer> itemClicks()
    {
        return adapter.observeClicks();
    }

    public View view() {
        return view;
    }

    public void swapAdapter(ArrayList<BusRoute> busRoutes) {
        adapter.swapAdapter(busRoutes);
    }

}
