package com.alpsmobi.busroutes.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alpsmobi.busroutes.R;
import com.alpsmobi.busroutes.model.BusRoute;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subjects.PublishSubject;

/**
 * Created by Prem on 11/5/2017.
 */

public class BusRouteViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.bus_route_image)
    ImageView imageBusRoute;
    @BindView(R.id.bus_route_name)
    TextView nameBusRoute;

    private View view;

    public BusRouteViewHolder(View itemView, PublishSubject<Integer> clickSubject) {
        super(itemView);
        this.view = itemView;
        ButterKnife.bind(this, view);
        view.setOnClickListener(v -> clickSubject.onNext(getAdapterPosition())
        );
    }

    void bind(BusRoute busRoute) {
        Glide.with(view.getContext()).load(busRoute.getImage()).into(imageBusRoute);

        nameBusRoute.setText(TextUtils.isEmpty(busRoute.getName()) ? "missing name" : busRoute.getName());
    }
}
