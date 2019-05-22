package com.mentoring.testing_api.openweathermap.dto.ById;

import lombok.Data;

import java.util.List;

@Data
public class ByIdDto {

    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private int dt;
    private Sys sys;
    private int id;
    private String name;
    private int cod;

}
