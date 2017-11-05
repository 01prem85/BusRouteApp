package com.alpsmobi.busroutes.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by Prem on 11/5/2017.
 */

public class BusRoute implements Serializable {

    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private Stop[] stops;
    @Expose
    private String description;
    @Expose
    private boolean accessible;
    @Expose
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stop[] getStops() {
        return stops;
    }

    public void setStops(Stop[] stops) {
        this.stops = stops;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
