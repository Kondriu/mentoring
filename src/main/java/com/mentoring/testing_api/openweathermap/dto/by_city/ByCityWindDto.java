package com.mentoring.testing_api.openweathermap.dto.by_city;

public class ByCityWindDto {
    
    private Integer speed;
    private Integer deg;

    public ByCityWindDto(Integer speed, Integer deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "ByCityWindDto{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }

}
