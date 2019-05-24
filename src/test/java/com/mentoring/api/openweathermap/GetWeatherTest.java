package com.mentoring.api.openweathermap;

import com.mentoring.api.BaseTest;
import com.mentoring.api.openweathermap.dto.ByCityDto;
import com.mentoring.api.openweathermap.dto.ByCoordinatesDto;
import com.mentoring.api.openweathermap.dto.ByIdDto;
import com.mentoring.api.openweathermap.dto.ByZipCodeDto;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class GetWeatherTest extends BaseTest {


    @Test
    public void testGetCurrentWeatherByCityName() {
        log.info("start test \"Get current weather by city name.\"");
        OpenWeather openWeather = new OpenWeather();
        ByCityDto response = openWeather.getCurrentWeatherByCity(propertiesReader().getValue("kiev.name"));

        Assert.assertEquals("Names of cities mismatch",
                propertiesReader().getValue("kiev.expected.name"),
                response.getName());
    }

    @Test
    public void testGetCurrentWeatherByCytyId() {
        log.info("start test \"Get current weather by city ID.\"");
        OpenWeather openWeather = new OpenWeather();
        ByIdDto response = openWeather.getCurrentWeatherById(propertiesReader().getValue("kiev.id"));

        Assert.assertEquals("Names of cities mismatch",
                propertiesReader().getValue("kiev.expected.name"),
                response.getName());
    }

    @Test
    public void testGetCurrentWeatherByCityCoordinates() {
        log.info("start test \"Get current weather by city Coordinates.\"");
        OpenWeather openWeather = new OpenWeather();
        ByCoordinatesDto response = openWeather.
                getCurrentWeatherByCoordinates(
                        propertiesReader().getValue("kiev.latitude"),
                        propertiesReader().getValue("kiev.longitude"));

        Assert.assertEquals("Names of cities mismatch",
                propertiesReader().getValue("kiev.expected.name.by.coordinates"),
                response.getName());
    }

    @Test
    public void testGetCurrentWeatherByCityZipCode() {
        log.info("start test \"Get current weather by ZIP code.\"");
        OpenWeather openWeather = new OpenWeather();
        String requestQuee = propertiesReader().getValue("kiev.zip") + "," + propertiesReader().getValue("country.code");
        ByZipCodeDto response = openWeather.getCurrentWeatherByZipCode(requestQuee);

        Assert.assertEquals("Names of cities mismatch",
                propertiesReader().getValue("kiev.expected.name.by.zip.code"),
                response.getName());
    }

    @Test
    public void testResponseBodyByCityName() throws IOException {
        OpenWeather openWeather = new OpenWeather();
        openWeather.assertContains(
                openWeather.getBodyByCityName(propertiesReader().getValue("kiev.name")),
                openWeather.getListItemsToValidate("src/test/resources/items.to.validate.by.name.txt"));
    }

    @Test
    public void testResponseBodyByCityId() {
        OpenWeather openWeather = new OpenWeather();
        openWeather.assertContains(
                openWeather.getBodyByCityId(propertiesReader().getValue("kiev.id")),
                openWeather.getListItemsToValidate("src/test/resources/items.to.validate.by.id.txt"));
    }

    @Test
    public void testResponseBodyByCityCoordinates() {
        OpenWeather openWeather = new OpenWeather();
        openWeather.assertContains(
                openWeather.getBodyByCityCoordinates(
                        propertiesReader().getValue("kiev.latitude"),
                        propertiesReader().getValue("kiev.longitude")),
                openWeather.getListItemsToValidate("src/test/resources/items.to.validate.by.coordinates.txt"));
    }

    @Test
    public void testResponseBodyByCityZipCode() {
        OpenWeather openWeather = new OpenWeather();
        openWeather.assertContains(
                openWeather.getBodyByCityName(propertiesReader().getValue("kiev.zip")),
                openWeather.getListItemsToValidate("src/test/resources/items.to.validate.by.zip.txt"));
    }
}
