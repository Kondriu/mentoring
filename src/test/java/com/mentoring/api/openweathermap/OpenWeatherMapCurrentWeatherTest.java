package com.mentoring.api.openweathermap;

import com.mentoring.api.BaseTest;
import com.mentoring.api.openweathermap.PropertyMappers.CoordinatesCityMapper;
import com.mentoring.api.openweathermap.PropertyMappers.IdCityMapper;
import com.mentoring.api.openweathermap.PropertyMappers.NameCityMapper;
import com.mentoring.api.openweathermap.PropertyMappers.ZipCityMapper;
import com.mentoring.api.openweathermap.dto.ByCityDto;
import com.mentoring.api.openweathermap.dto.ByCoordinatesDto;
import com.mentoring.api.openweathermap.dto.ByIdDto;
import com.mentoring.api.openweathermap.dto.ByZipCodeDto;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class OpenWeatherMapCurrentWeatherTest extends BaseTest {

    private OpenWeatherService openWeatherService = new OpenWeatherService();

    @Test
    @FileParameters(value = "src/test/resources/cityProvider.csv", mapper = NameCityMapper.class)
    public void testGetCurrentWeatherByCityName(String cityName) {
        ByCityDto response = openWeatherService.getCurrentWeatherByCity(cityName);

        Assert.assertEquals("Names of cities mismatch",
                cityName,
                response.getName());
    }

    @Test
    @FileParameters(value = "src/test/resources/cityProvider.csv", mapper = IdCityMapper.class)
    public void testGetCurrentWeatherByCityId(String id, String cityName) {
        ByIdDto response = openWeatherService.getCurrentWeatherById(id);

        Assert.assertEquals("Names of cities mismatch",
                cityName,
                response.getName());
    }

    @Test
    @FileParameters(value = "src/test/resources/cityProvider.csv", mapper = CoordinatesCityMapper.class)
    public void testGetCurrentWeatherByCityCoordinates(String lon, String lat, String expectedByCoordinates) {
        ByCoordinatesDto response = openWeatherService.
                getCurrentWeatherByCoordinates(lat, lon);
        Assert.assertEquals("Names of cities mismatch",
                expectedByCoordinates,
                response.getName());
    }

    @Test
    @FileParameters(value = "src/test/resources/cityProvider.csv", mapper = ZipCityMapper.class)
    public void testGetCurrentWeatherByCityZipCode(String zipCode, String isoCode, String expectedByZip) {
        String requestQuee = zipCode + "," + isoCode;
        ByZipCodeDto response = openWeatherService.getCurrentWeatherByZipCode(requestQuee);

        Assert.assertEquals("Names of cities mismatch",
                expectedByZip,
                response.getName());
    }

    @Test
    public void testResponseBodyByCityName() {
        openWeatherService.assertContains(
                openWeatherService.getBodyByCityName(propertiesReader.getValue("city.name")),
                openWeatherService.getListItemsToValidate("src/test/resources/items.to.validate.by.name.txt"));
    }

    @Test
    public void testResponseBodyByCityId() {
        openWeatherService.assertContains(
                openWeatherService.getBodyByCityId(propertiesReader.getValue("city.id")),
                openWeatherService.getListItemsToValidate("src/test/resources/items.to.validate.by.id.txt"));
    }

    @Test
    public void testResponseBodyByCityCoordinates() {
        openWeatherService.assertContains(
                openWeatherService.getBodyByCityCoordinates(
                        propertiesReader.getValue("city.latitude"),
                        propertiesReader.getValue("city.longitude")),
                openWeatherService.getListItemsToValidate("src/test/resources/items.to.validate.by.coordinates.txt"));
    }

    @Test
    public void testResponseBodyByCityZipCode() {
        openWeatherService.assertContains(
                openWeatherService.getBodyByCityZipCode(propertiesReader.getValue("city.zip")),
                openWeatherService.getListItemsToValidate("src/test/resources/items.to.validate.by.zip.txt"));
    }

    @Test
    public void testJsonSchemaValidationByCityName() {
        openWeatherService.assertJsonSchemaByCityName(propertiesReader.getValue("city.name"));
    }

    @Test
    public void testJsonSchemaValidationByCityId() {
        openWeatherService.assertJsonSchemaByCityId(propertiesReader.getValue("city.id"));
    }

    @Test
    public void testJsonSchemaValidationByCityCoordinates() {
        openWeatherService.assertJsonSchemaByCityCoordinates(
                propertiesReader.getValue("city.latitude"),
                propertiesReader.getValue("city.longitude"));
    }

    @Test
    public void testJsonSchemaValidationByCityZip() {
        openWeatherService.assertJsonSchemaByCityZip(propertiesReader.getValue("city.zip"));
    }

}
