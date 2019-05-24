package com.mentoring.api.openweathermap;

import com.mentoring.api.BaseTest;
import com.mentoring.api.openweathermap.dto.ByCityDto;
import com.mentoring.api.openweathermap.dto.ByCoordinatesDto;
import com.mentoring.api.openweathermap.dto.ByIdDto;
import com.mentoring.api.openweathermap.dto.ByZipCodeDto;
import org.junit.Assert;
import org.junit.Test;

public class OpenWeatherMapCurrentWeatherTest extends BaseTest {

    private OpenWeatherService openWeatherService = new OpenWeatherService();


    @Test
    public void testGetCurrentWeatherByCityName() {
        ByCityDto response = openWeatherService.getCurrentWeatherByCity(propertiesReader().getValue("kiev.name"));

        Assert.assertEquals("Names of cities mismatch",
                propertiesReader().getValue("expected.name"),
                response.getName());
    }

    @Test
    public void testGetCurrentWeatherByCytyId() {
        ByIdDto response = openWeatherService.getCurrentWeatherById(propertiesReader().getValue("kiev.id"));

        Assert.assertEquals("Names of cities mismatch",
                propertiesReader().getValue("expected.name"),
                response.getName());
    }

    @Test
    public void testGetCurrentWeatherByCityCoordinates() {
        ByCoordinatesDto response = openWeatherService.
                getCurrentWeatherByCoordinates(
                        propertiesReader().getValue("kiev.latitude"),
                        propertiesReader().getValue("kiev.longitude"));

        Assert.assertEquals("Names of cities mismatch",
                propertiesReader().getValue("expected.name.by.coordinates"),
                response.getName());
    }

    @Test
    public void testGetCurrentWeatherByCityZipCode() {
        String requestQuee = propertiesReader().getValue("kiev.zip") + "," + propertiesReader().getValue("country.code");
        ByZipCodeDto response = openWeatherService.getCurrentWeatherByZipCode(requestQuee);

        Assert.assertEquals("Names of cities mismatch",
                propertiesReader().getValue("expected.name.by.zip.code"),
                response.getName());
    }

    @Test
    public void testResponseBodyByCityName() {
        openWeatherService.assertContains(
                openWeatherService.getBodyByCityName(propertiesReader().getValue("kiev.name")),
                openWeatherService.getListItemsToValidate("src/test/resources/items.to.validate.by.name.txt"));
    }

    @Test
    public void testResponseBodyByCityId() {
        openWeatherService.assertContains(
                openWeatherService.getBodyByCityId(propertiesReader().getValue("kiev.id")),
                openWeatherService.getListItemsToValidate("src/test/resources/items.to.validate.by.id.txt"));
    }

    @Test
    public void testResponseBodyByCityCoordinates() {
        openWeatherService.assertContains(
                openWeatherService.getBodyByCityCoordinates(
                        propertiesReader().getValue("kiev.latitude"),
                        propertiesReader().getValue("kiev.longitude")),
                openWeatherService.getListItemsToValidate("src/test/resources/items.to.validate.by.coordinates.txt"));
    }

    @Test
    public void testResponseBodyByCityZipCode() {
        openWeatherService.assertContains(
                openWeatherService.getBodyByCityZipCode(propertiesReader().getValue("kiev.zip")),
                openWeatherService.getListItemsToValidate("src/test/resources/items.to.validate.by.zip.txt"));
    }



}
