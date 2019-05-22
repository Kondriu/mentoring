package com.mentoring.testing_api.openweathermap;

import com.mentoring.testing_api.openweathermap.dto.by_city.ByCityDto;
import com.mentoring.testing_api.openweathermap.dto.by_id.ByIdDto;
import io.restassured.RestAssured;

public class OpenWeather {

    public static final String OPENWEATHER_URI = "https://api.openweathermap.org/";
    public static final String BY_CITY_PATH = "data/2.5/weather?";
    public static final String API_KEY = "ebb0d0cda72cfeb52c42fda76e750101";

    public OpenWeather() {
        RestAssured.baseURI = OPENWEATHER_URI;
    }

    public String makeRequestString(String requestParam){
        return BY_CITY_PATH + "q=" + requestParam + "&APPID=" + API_KEY;
    }

    public String makeRequestString(Integer requestParam){
        return BY_CITY_PATH + "id=" +requestParam + "&APPID=" + API_KEY;
    }



    public ByCityDto getCurrentWeatherByCity(String cityName) {
        return RestAssured
                .given()
                .get(makeRequestString(cityName))
                .thenReturn()
                .as(ByCityDto.class);
    }

    public ByIdDto getCurrentWeatherById(Integer cityId){
        String str = makeRequestString(cityId);
        System.out.println(str);
                return RestAssured
                .given()
                .get(str)
                .thenReturn()
                .as(ByIdDto.class);

    }

    


}
