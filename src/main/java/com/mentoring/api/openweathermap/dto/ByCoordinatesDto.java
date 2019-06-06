package com.mentoring.api.openweathermap.dto;

import com.mentoring.api.openweathermap.dto.details_dto.*;

import java.util.List;

public class ByCoordinatesDto {

    private Coord coord;
    private Sys sys;
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private int dt;
    private int id;
    private String name;
    private int cod;
    private int timezone;
    private String base;
    private int visibility;

    public Coord getCoord() {
        return coord;
    }

    public Sys getSys() {
        return sys;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Rain getRain() {
        return rain;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public int getDt() {
        return dt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }

    public int getTimezone() {
        return timezone;
    }

    public String getBase() {
        return base;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }
}
