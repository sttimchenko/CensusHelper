package com.sttimchenko.censushelper.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Aim {
    private int id;
    private String streetName;
    private String buildingNumber;
    private List<String> flatsNumbers;
    private LatLng cordinates;

    public Aim(){

    }

    public int getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public List<String> getFlatsNumbers() {
        if (flatsNumbers == null) return new ArrayList<>();

        return flatsNumbers;
    }

    public LatLng getCordinates() {
        return cordinates;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setFlatsNumbers(List<String> flatsNumbers) {
        this.flatsNumbers = flatsNumbers;
    }

    public void setCordinates(LatLng cordinates) {
        this.cordinates = cordinates;
    }
}
