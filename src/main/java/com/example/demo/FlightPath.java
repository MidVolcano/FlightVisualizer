package com.example.demo;

public class FlightPath {
    private String flight;
    private double originLat;
    private double originLng;
    private double destLat;
    private double destLng;
    private String originCode;
    private String destCode;

    public FlightPath(String flight, String originCode, String destCode,
                      double originLat, double originLng, double destLat, double destLng) {
        this.flight = flight;
        this.originCode = originCode;
        this.destCode = destCode;
        this.originLat = originLat;
        this.originLng = originLng;
        this.destLat = destLat;
        this.destLng = destLng;
    }

    public String getFlight() { return flight; }
    public String getOriginCode() { return originCode; }
    public String getDestCode() { return destCode; }
    public double getOriginLat() { return originLat; }
    public double getOriginLng() { return originLng; }
    public double getDestLat() { return destLat; }
    public double getDestLng() { return destLng; }
}
