package com.alpsmobi.busroutes.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by Prem on 11/5/2017.
 */

public class Stop implements Serializable{

    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
