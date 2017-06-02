package com.example.patel.quakereport;

/**
 * Created by Patel on 01-06-2017.
 */

public class EarthquakeClass {

    private double Magnitude;
    private String Location;
    private long TimeInMilliseconds;

    public EarthquakeClass(double magnitude, String location, long timeInMilliseconds) {
        Magnitude = magnitude;
        Location = location;
        TimeInMilliseconds = timeInMilliseconds;
    }

    public double getMagnitude() {
        return Magnitude;
    }

    public void setMagnitude(double magnitude) {
        Magnitude = magnitude;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public long getTimeInMilliseconds() {
        return TimeInMilliseconds;
    }

    public void setTimeInMilliseconds(long timeInMilliseconds) {
        TimeInMilliseconds = timeInMilliseconds;
    }
}
