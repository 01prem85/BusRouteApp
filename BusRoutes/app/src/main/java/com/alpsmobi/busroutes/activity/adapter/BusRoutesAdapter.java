package com.alpsmobi.busroutes.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alpsmobi.busroutes.R;
import com.alpsmobi.busroutes.model.BusRoute;

import java.util.ArrayList;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by Prem on 11/5/2017.
 */

public class BusRoutesAdapter extends RecyclerView.Adapter<BusRouteViewHolder> {

    private final PublishSubject<Integer> itemClicks = PublishSubject.create();
    ArrayList<BusRoute> busRoutes = new ArrayList<>();

    public void swapAdapter(ArrayList<BusRoute> busRoutes) {
        this.busRoutes.clear();
        this.busRoutes.addAll(busRoutes);
        notifyDataSetChanged();
    }

    public Observable<Integer> observeClicks() {
        return itemClicks;
    }

    @Override
    public BusRouteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bus_route, parent, false);
        return new BusRouteViewHolder(view ,itemClicks);
    }

    @Override
    public void onBindViewHolder(BusRouteViewHolder holder, int position) {
        BusRoute busRoute = busRoutes.get(position);
        holder.bind(busRoute);
    }

    @Override
    public int getItemCount() {
        if (busRoutes != null && busRoutes.size() > 0) {
            return busRoutes.size();
        } else {
            return 0;
        }
    }
}
