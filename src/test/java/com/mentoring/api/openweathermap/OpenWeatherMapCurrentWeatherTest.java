package com.mentoring.api.openweathermap;

import com.mentoring.api.BaseTest;
import com.mentoring.api.openweathermap.dto.ByCityDto;
import com.mentoring.api.openweathermap.dto.ByCoordinatesDto;
import com.mentoring.api.openweathermap.dto.ByIdDto;
import com.mentoring.api.openweathermap.dto.ByZipCodeDto;
import org.junit.Assert;
import org.junit.Test;

public class OpenWeatherMapCurrentWeatherTest extends BaseTest {


    @Test
    public void testGetCurrentWeatherByCityName() {
        log.info("start test \"Get current weather by city name.\"");
        OpenWeatherService openWeatherService = new OpenWeatherService();
        ByCityDto response = openWeatherService.getCurrentWeatherByCity(propertiesReader().getValue("kiev.name"));

        Assert.assertEquals("Names of cities mismatch",
                propertiesReader().getValue("kiev.expected.name"),
                response.getName());
    }

    @Test
    public void testGetCurrentWeatherByCytyId() {
        log.info("start test \"Get current weather by city ID.\"");
        OpenWeatherService openWeatherService = new OpenWeatherService();
        ByIdDto response = openWeatherService.getCurrentWeatherById(propertiesReader().getValue("kiev.id"));

        Assert.assertEquals("Names of cities mismatch",
                propertiesReader().getValue("kiev.expected.name"),
                response.getName());
    }

    @Test
    public void testGetCurrentWeatherByCityCoordinates() {
        log.info("start test \"Get current weather by city Coordinates.\"");
        OpenWeatherService openWeatherService = new OpenWeatherService();
        ByCoordinatesDto response = openWeatherService.
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
        OpenWeatherService openWeatherService = new OpenWeatherService();
        String requestQuee = propertiesReader().getValue("kiev.zip") + "," + propertiesReader().getValue("country.code");
        ByZipCodeDto response = openWeatherService.getCurrentWeatherByZipCode(requestQuee);

        Assert.assertEquals("Names of cities mismatch",
                propertiesReader().getValue("kiev.expected.name.by.zip.code"),
                response.getName());
    }

    @Test
    public void testResponseBodyByCityName() {
        log.info("test Response Body by city name");
        OpenWeatherService openWeatherService = new OpenWeatherService();
        openWeatherService.assertContains(
                openWeatherService.getBodyByCityName(propertiesReader().getValue("kiev.name")),
                openWeatherService.getListItemsToValidate("src/test/resources/items.to.validate.by.name.txt"));
    }

    @Test
    public void testResponseBodyByCityId() {
        log.info("test Response Body by city ID");
        OpenWeatherService openWeatherService = new OpenWeatherService();
        openWeatherService.assertContains(
                openWeatherService.getBodyByCityId(propertiesReader().getValue("kiev.id")),
                openWeatherService.getListItemsToValidate("src/test/resources/items.to.validate.by.id.txt"));
    }

    @Test
    public void testResponseBodyByCityCoordinates() {
        log.info("test Response Body by city coordinates");
        OpenWeatherService openWeatherService = new OpenWeatherService();
        openWeatherService.assertContains(
                openWeatherService.getBodyByCityCoordinates(
                        propertiesReader().getValue("kiev.latitude"),
                        propertiesReader().getValue("kiev.longitude")),
                openWeatherService.getListItemsToValidate("src/test/resources/items.to.validate.by.coordinates.txt"));
    }

    @Test
    public void testResponseBodyByCityZipCode() {
        log.info("test Response Body by city ZIP code");
        OpenWeatherService openWeatherService = new OpenWeatherService();
        openWeatherService.assertContains(
                openWeatherService.getBodyByCityName(propertiesReader().getValue("kiev.zip")),
                openWeatherService.getListItemsToValidate("src/test/resources/items.to.validate.by.zip.txt"));
    }
}
