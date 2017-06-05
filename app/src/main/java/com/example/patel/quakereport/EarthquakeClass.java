package com.example.patel.quakereport;

/**
 * Created by Patel on 01-06-2017.
 */

public class EarthquakeClass {

    private double Magnitude;
    private String Url;
    private String Location;
    private long TimeInMilliseconds;

    public EarthquakeClass(double magnitude, String location, long timeInMilliseconds, String url) {
        Magnitude = magnitude;
        Location = location;
        TimeInMilliseconds = timeInMilliseconds;
        Url = url;
    }

    public double getMagnitude() {
        return Magnitude;
    }


    public String getLocation() {
        return Location;
    }


    public long getTimeInMilliseconds() {
        return TimeInMilliseconds;
    }


    public String getUrl() {
        return Url;
    }
}
