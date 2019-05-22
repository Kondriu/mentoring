package com.mentoring.testing_api.openweathermap.dto.by_coordinates;


import java.util.List;

public class ByCoordinatesDto {
    public Coord coord;
    public Sys sys;
    public List<Weather> weather;
    public Main main;
    public Wind wind;
    public Rain rain;
    public Clouds clouds;
    public int dt;
    public int id;
    public String name;
    public int cod;
}
