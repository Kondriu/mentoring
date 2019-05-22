package com.mentoring.testing_api.openweathermap.dto.by_coordinates;

import lombok.Data;

@Data
public class Sys {
    public String country;
    public int sunrise;
    public int sunset;
}
