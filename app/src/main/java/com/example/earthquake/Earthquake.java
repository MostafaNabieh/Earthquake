package com.example.earthquake;

public class Earthquake {
    private String magnitude;
    private String location;
    private String data;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Earthquake(String magnitude, String location, String data, String url) {
        this.magnitude = magnitude;
        this.location = location;
        this.data = data;
        this.url = url;
    }

    public Earthquake(String magnitude, String location, String data) {
        this.magnitude = magnitude;
        this.location = location;
        this.data = data;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
