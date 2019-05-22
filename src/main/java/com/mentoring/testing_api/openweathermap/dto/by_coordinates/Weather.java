package com.mentoring.testing_api.openweathermap.dto.by_coordinates;

import lombok.Data;

@Data
public class Weather {
    public int id;
    public String main;
    public String description;
    public String icon;
}
