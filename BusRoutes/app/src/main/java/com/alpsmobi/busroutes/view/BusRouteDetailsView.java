package com.alpsmobi.busroutes.view;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alpsmobi.busroutes.R;
import com.alpsmobi.busroutes.activity.BusRouteDetailActivity;
import com.alpsmobi.busroutes.model.BusRoute;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Prem on 11/5/2017.
 */

public class BusRouteDetailsView {

    @BindView(R.id.bus_route_image)
    ImageView imageBusRoute;
    @BindView(R.id.bus_route_desc)
    TextView busRouteDescription;
    @BindView(R.id.bus_route_name)
    TextView busRouteName;
    @BindView(R.id.accessibility_image)
    ImageView  imageAccessibility;
    @BindView(R.id.bus_route_layout)
    LinearLayout busRouteLayout;

    private View view;

    public BusRouteDetailsView(BusRouteDetailActivity activity, BusRoute busRoute) {
        FrameLayout layout = new FrameLayout(activity);
        layout.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        view = LayoutInflater.from(activity).inflate(R.layout.activity_bus_route_detail,layout,true);
        ButterKnife.bind(this,view);

        Glide.with(activity).load(busRoute.getImage()).into(imageBusRoute);
        busRouteDescription.setVisibility(View.VISIBLE);
        busRouteDescription.setText(TextUtils.isEmpty(busRoute.getDescription()) ? "no description" : busRoute.getDescription());
        busRouteName.setText(TextUtils.isEmpty(busRoute.getName()) ? "no route name" : busRoute.getName());

        if(busRoute.isAccessible()) {
            imageAccessibility.setVisibility(View.VISIBLE);
            Glide.with(activity).load(R.drawable.ic_accessibility).into(imageAccessibility);
        }

        for (int i=0; i< busRoute.getStops().length; i++ ){
            View routeView = LayoutInflater.from(activity).inflate(R.layout.item_bus_stop, null);
            TextView busRouteTextView = ButterKnife.findById(routeView, R.id.bus_route);
            ImageView connectorImage = ButterKnife.findById(routeView, R.id.connector_image);
            Log.d("BusRouteDetailsView ", "stops: " + busRoute.getStops()[i].getName());
            busRouteTextView.setText(busRoute.getStops()[i].getName());
            if(i != 0) {
                connectorImage.setVisibility(View.VISIBLE);
            }
            busRouteLayout.addView(routeView);
        }
    }

    public View view()
    {
        return view;
    }
}
