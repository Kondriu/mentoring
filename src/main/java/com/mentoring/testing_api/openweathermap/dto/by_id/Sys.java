package com.mentoring.testing_api.openweathermap.dto.by_id;

import lombok.Data;

@Data
public class Sys {

    private int type;
    private int id;
    private double message;
    private String country;
    private int sunrise;
    private int sunset;
}
