package com.example.simpleparadox.listycity;

import android.widget.Adapter;

import java.io.Serializable;

public class City{
    private String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
