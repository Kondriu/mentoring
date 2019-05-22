package com.mentoring.testing_api.openweathermap.dto.ByCity;

public class ByCityCloudsDto {

    private Integer all;

    public ByCityCloudsDto(Integer all) {
        this.all = all;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "ByCityCloudsDto{" +
                "all=" + all +
                '}';
    }


}
