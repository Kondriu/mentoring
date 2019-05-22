package com.mentoring.testing_api.openweathermap.dto.by_coordinates;

import lombok.Data;

@Data
public class Main {
    public double temp;
    public int humidity;
    public int pressure;
    public double temp_min;
    public double temp_max;
}
