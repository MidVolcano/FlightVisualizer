package com.example.demo;

public class Airport {
    private String code;
    private double lat;
    private double lng;
    private String name;

    public Airport(String code, double lat, double lng, String name) {
        this.code = code;
        this.lat = lat;
        this.lng = lng;
        this.name = name;
    }

    public String getCode() { 
    	return code; }
    public double getLat() { 
    	return lat; }
    public double getLng() { 
    	return lng; }
    public String getName() { 
    	return name; }
}
