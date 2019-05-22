package com.mentoring.testing_api.openweathermap;

import com.mentoring.testing_api.openweathermap.dto.by_city.ByCityDto;
import com.mentoring.testing_api.openweathermap.dto.by_id.ByIdDto;
import org.junit.Test;

public class GetWeatherByCityNameTest {


    @Test
    public void testGetCurrentWeatherByCity() {
        System.out.println("BY cyty");
        OpenWeather openWeather = new OpenWeather();
        ByCityDto response = openWeather.getCurrentWeatherByCity("Kiev");
//        Long temp = Math.round(response.getMain().getTemp()-273.15);
        System.out.println(Math.round(response.getMain().getTemp()-273.15));
    }

    @Test
    public void testGetCurrentWeatherById() {
        System.out.println("By ID");
        OpenWeather openWeather = new OpenWeather();
        ByIdDto response = openWeather.getCurrentWeatherById(703448);
//        Long temp = Math.round(response.getMain().getTemp()-273.15);
        System.out.println(Math.round(response.getMain().getTemp()-273.15));
    }

}
