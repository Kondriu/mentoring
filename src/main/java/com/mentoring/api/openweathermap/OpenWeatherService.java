package com.mentoring.api.openweathermap;

import com.mentoring.api.openweathermap.dto.*;
import com.mentoring.api.utills.PropertiesReader;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class OpenWeatherService {

    private static final Logger log = Logger.getLogger(OpenWeatherService.class);

    public OpenWeatherService() {
        RestAssured.baseURI = propertiesReader.getValue("openweather.uri");
    }

    public PropertiesReader propertiesReader = new PropertiesReader();

    public ByCityDto getCurrentWeatherByCity(String cityName) {
        return RestAssured
                .given()
                .log().ifValidationFails()
                .log().uri()
                .queryParam("q", cityName)
                .queryParam("appid", propertiesReader.getValue("openweather.api.key"))
                .get(propertiesReader.getValue("openweather.search.path"))
                .thenReturn()
                .then()
                .assertThat().statusCode(200)
                .and()
                .assertThat().contentType("application/json")
                .log().ifError()
                .extract()
                .as(ByCityDto.class);
    }

    public ByIdDto getCurrentWeatherById(String cityId) {
        return RestAssured
                .given()
                .log().uri()
                .queryParam("id", cityId)
                .queryParam("appid", propertiesReader.getValue("openweather.api.key"))
                .get(propertiesReader.getValue("openweather.search.path"))
                .thenReturn()
                .then()
                .assertThat().statusCode(200)
                .and()
                .assertThat().contentType("application/json")
                .log().ifError()
                .extract()
                .as(ByIdDto.class);
    }

    public ByCoordinatesDto getCurrentWeatherByCoordinates(String lat, String lon) {
        return RestAssured
                .given()
                .log().uri()
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("appid", propertiesReader.getValue("openweather.api.key"))
                .get(propertiesReader.getValue("openweather.search.path"))
                .thenReturn()
                .then()
                .assertThat().statusCode(200)
                .and()
                .assertThat().contentType("application/json")
                .log().ifError()
                .extract()
                .as(ByCoordinatesDto.class);
    }

    public ByZipCodeDto getCurrentWeatherByZipCode(String zipCode){
        return  RestAssured
                .given()
                .log().uri()
                .queryParam("zip", zipCode)
                .queryParam("appid", propertiesReader.getValue("openweather.api.key"))
                .get(propertiesReader.getValue("openweather.search.path"))
                .thenReturn()
                .then()
                .assertThat().statusCode(200)
                .and()
                .assertThat().contentType("application/json")
                .log().ifError()
                .extract()
                .as(ByZipCodeDto.class);
    }

    public ResponseBody getBodyByCityName(String cityName){
        return RestAssured
                .given()
                .log().uri()
                .queryParam("q", cityName)
                .queryParam("appid", propertiesReader.getValue("openweather.api.key"))
                .get(propertiesReader.getValue("openweather.search.path"))
                .getBody();
    }
    public ResponseBody getBodyByCityId(String cityId){
        return RestAssured
                .given()
                .log().uri()
                .queryParam("id", cityId)
                .queryParam("appid", propertiesReader.getValue("openweather.api.key"))
                .get(propertiesReader.getValue("openweather.search.path"))
                .getBody();
    }
    public ResponseBody getBodyByCityCoordinates(String lat, String lon){
        return RestAssured
                .given()
                .log().uri()
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("appid", propertiesReader.getValue("openweather.api.key"))
                .get(propertiesReader.getValue("openweather.search.path"))
                .getBody();
    }
    public ResponseBody getBodyByCityZipCode(String zipCode){
        return RestAssured
                .given()
                .log().uri()
                .queryParam("zip", zipCode)
                .queryParam("appid", propertiesReader.getValue("openweather.api.key"))
                .get(propertiesReader.getValue("openweather.search.path"))
                .getBody();
    }

    public void assertContains(ResponseBody body, List<String> titles){
        for (String item : titles) {
            Assert.assertTrue("item "+item+" doesn't exist", body.asString().contains(item));
        }
    }

    public List<String> getListItemsToValidate(String pathToFile) {
        List<String> itemsList = null;
        try {
            itemsList = Files.lines(Paths.get(pathToFile)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemsList;
    }
}
