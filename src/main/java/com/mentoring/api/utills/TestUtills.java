package com.mentoring.api.utills;

public class TestUtills {

    public static Long convertToCelsius(Double kelvins) {
        return Math.round(kelvins - 273.15);
    }
}
