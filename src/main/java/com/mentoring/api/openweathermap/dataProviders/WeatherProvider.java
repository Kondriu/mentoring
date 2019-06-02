package com.mentoring.api.openweathermap.dataProviders;

import java.util.Objects;

public class WeatherProvider {

    private String id;
    private String cityName;
    private String lat;
    private String lon;
    private String zip;
    private String iso;
    private String expCoord;
    private String extZip;

    public WeatherProvider(String id, String cityName, String lat, String lon, String zip, String iso, String expCoord, String extZip) {
        this.id = id;
        this.cityName = cityName;
        this.lat = lat;
        this.lon = lon;
        this.zip = zip;
        this.iso = iso;
        this.expCoord = expCoord;
        this.extZip = extZip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getExpCoord() {
        return expCoord;
    }

    public void setExpCoord(String expCoord) {
        this.expCoord = expCoord;
    }

    public String getExtZip() {
        return extZip;
    }

    public void setExtZip(String extZip) {
        this.extZip = extZip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherProvider that = (WeatherProvider) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cityName, that.cityName) &&
                Objects.equals(lat, that.lat) &&
                Objects.equals(lon, that.lon) &&
                Objects.equals(zip, that.zip) &&
                Objects.equals(iso, that.iso) &&
                Objects.equals(expCoord, that.expCoord) &&
                Objects.equals(extZip, that.extZip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityName, lat, lon, zip, iso, expCoord, extZip);
    }

    @Override
    public String toString() {
        return "WeatherProvider{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", zip='" + zip + '\'' +
                ", iso='" + iso + '\'' +
                ", expCoord='" + expCoord + '\'' +
                ", extZip='" + extZip + '\'' +
                '}';
    }
}

