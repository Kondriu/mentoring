package com.mentoring.testing_api.openweathermap.dto.ById;

import lombok.Data;

@Data
public class Main {
    private double temp;
    private int pressure;
    private int humidity;
    private double temp_min;
    private double temp_max;
}
