package com.mentoring.api.openweathermap;

import com.mentoring.api.BaseTest;
import com.mentoring.api.openweathermap.propertyMappers.WeatherParamsMapper;
import com.mentoring.api.openweathermap.dataProviders.WeatherProvider;
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
    private final String errorMessage = "Names of cities mismatch";
    private final String cityProviderPath = "src/test/resources/cityProvider.csv";

    @Test
    @FileParameters(value = cityProviderPath, mapper = WeatherParamsMapper.class)
    public void testGetCurrentWeatherByCityName(WeatherProvider weatherProvider) {
        ByCityDto byCityIdResponse = openWeatherService.getCurrentWeatherByCity(weatherProvider.getCityName());

        Assert.assertEquals(errorMessage,
                weatherProvider.getCityName(),
                byCityIdResponse.getName());
    }

    @Test
    @FileParameters(value = cityProviderPath, mapper = WeatherParamsMapper.class)
    public void testGetCurrentWeatherByCityId(WeatherProvider weatherProvider) {
        ByIdDto byIdResponse = openWeatherService.getCurrentWeatherById(weatherProvider.getId());

        Assert.assertEquals(errorMessage,
                weatherProvider.getCityName(),
                byIdResponse.getName());
    }

    @Test
    @FileParameters(value = cityProviderPath, mapper = WeatherParamsMapper.class)
    public void testGetCurrentWeatherByCityCoordinates(WeatherProvider weatherProvider) {
        ByCoordinatesDto byCoordinatesResponse = openWeatherService.
                getCurrentWeatherByCoordinates(weatherProvider.getLat(), weatherProvider.getLon());
        Assert.assertEquals(errorMessage,
                weatherProvider.getExpCoord(),
                byCoordinatesResponse.getName());
    }

    @Test
    @FileParameters(value = cityProviderPath, mapper = WeatherParamsMapper.class)
    public void testGetCurrentWeatherByCityZipCode(WeatherProvider weatherProvider) {
        String collectedZipAndIsoValues = weatherProvider.getZip() + "," + weatherProvider.getIso();
        ByZipCodeDto byZipCodeResponse = openWeatherService.getCurrentWeatherByZipCode(collectedZipAndIsoValues);

        Assert.assertEquals(errorMessage,
                weatherProvider.getExtZip(),
                byZipCodeResponse.getName());
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
