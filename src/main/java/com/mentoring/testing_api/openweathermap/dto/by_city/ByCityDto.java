package com.mentoring.testing_api.openweathermap.dto.ByCity;

import java.util.List;


public class ByCityDto {

    private ByCityCoordDto coord;
    private List<ByCityWeatherDto> weather;
    private String base;
    private ByCityMainDto main;
    private Integer visibility;
    private ByCityWindDto wind;
    private ByCityCloudsDto clouds;
    private Integer dt;
    private ByCitySysDto sys;
    private Integer id;
    private String name;
    private Integer cod;

    public ByCityDto(
            ByCityCoordDto coord,
            List<ByCityWeatherDto> weather,
            String base,
            ByCityMainDto main,
            Integer visibility,
            ByCityWindDto wind,
            ByCityCloudsDto clouds,
            Integer dt,
            ByCitySysDto sys,
            Integer id,
            String name,
            Integer cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public ByCityCoordDto getCoord() {
        return coord;
    }

    public void setCoord(ByCityCoordDto coord) {
        this.coord = coord;
    }

    public List<ByCityWeatherDto> getWeather() {
        return weather;
    }

    public void setWeather(List<ByCityWeatherDto> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public ByCityMainDto getMain() {
        return main;
    }

    public void setMain(ByCityMainDto main) {
        this.main = main;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public ByCityWindDto getWind() {
        return wind;
    }

    public void setWind(ByCityWindDto wind) {
        this.wind = wind;
    }

    public ByCityCloudsDto getClouds() {
        return clouds;
    }

    public void setClouds(ByCityCloudsDto clouds) {
        this.clouds = clouds;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public ByCitySysDto getSys() {
        return sys;
    }

    public void setSys(ByCitySysDto sys) {
        this.sys = sys;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "ByCityDto{" +
                "coord=" + coord +
                ", weather=" + weather +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", dt=" + dt +
                ", sys=" + sys +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }
}
