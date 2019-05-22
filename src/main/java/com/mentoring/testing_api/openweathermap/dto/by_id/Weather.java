package com.mentoring.testing_api.openweathermap.dto.by_id;

import lombok.Data;

@Data
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
