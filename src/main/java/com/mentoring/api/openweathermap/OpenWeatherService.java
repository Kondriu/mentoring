package com.mentoring.api.openweathermap;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.mentoring.api.openweathermap.dto.*;
import com.mentoring.api.utills.PropertiesReader;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ResponseBody;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class OpenWeatherService {

    private static final Logger log = Logger.getLogger(OpenWeatherService.class);

    public PropertiesReader propertiesReader = new PropertiesReader();

    JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
            .setValidationConfiguration(
                    ValidationConfiguration.newBuilder()
                            .setDefaultVersion(SchemaVersion.DRAFTV4).freeze())
            .freeze();

    //JsonSchemaValidator jsonSchemaValidator;


    public ByCityDto getCurrentWeatherByCity(String cityName) {
        log.info("start test \"Get current weather by city name.\"");

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
        log.info("start test \"Get current weather by city ID.\"");

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
        log.info("start test \"Get current weather by city Coordinates.\"");

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
        log.info("start test \"Get current weather by ZIP code.\"");

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
        log.info("test Response Body by city name");

        return RestAssured
                .given()
                .log().uri()
                .queryParam("q", cityName)
                .queryParam("appid", propertiesReader.getValue("openweather.api.key"))
                .get(propertiesReader.getValue("openweather.search.path"))
                .getBody();
    }
    public ResponseBody getBodyByCityId(String cityId){
        log.info("test Response Body by city ID");

        return RestAssured
                .given()
                .log().uri()
                .queryParam("id", cityId)
                .queryParam("appid", propertiesReader.getValue("openweather.api.key"))
                .get(propertiesReader.getValue("openweather.search.path"))
                .getBody();
    }
    public ResponseBody getBodyByCityCoordinates(String lat, String lon){
        log.info("test Response Body by city coordinates");

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
        log.info("test Response Body by city ZIP code");

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


    public void validateJsonSchemaByCityName(String cityName){
        log.info("validation JSON Schema by City Name");
        RestAssured
                .given()
                .log().uri()
                .queryParam("q", cityName)
                .queryParam("appid", propertiesReader.getValue("openweather.api.key"))
                .get(propertiesReader.getValue("openweather.search.path"))
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json")
                        .using(jsonSchemaFactory))
                .log().ifError().extract()
        ;
    }

    public void validateJsonSchemaByCityId(String cityId){
        log.info("validation JSON Schema by City ID");

        RestAssured
                .given()
                .log().uri()
                .queryParam("id", cityId)
                .queryParam("appid", propertiesReader.getValue("openweather.api.key"))
                .get(propertiesReader.getValue("openweather.search.path"))
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json")
                        .using(jsonSchemaFactory))
                .log().ifError().extract()
        ;
    }

    public void validateJsonSchemaByCityCoordinates(String lat, String lon){
        log.info("validation JSON Schema by City coordinates");

        RestAssured
                .given()
                .log().uri()
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("appid", propertiesReader.getValue("openweather.api.key"))
                .get(propertiesReader.getValue("openweather.search.path"))
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json")
                        .using(jsonSchemaFactory))
                .log().ifError().extract()
        ;
    }

    public void validateJsonSchemaByCityZip(String cityZip){
        log.info("validation JSON Schema by City ZIP");

        RestAssured
                .given()
                .log().uri()
                .queryParam("zip", cityZip)
                .queryParam("appid", propertiesReader.getValue("openweather.api.key"))
                .get(propertiesReader.getValue("openweather.search.path"))
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json")
                        .using(jsonSchemaFactory))
                .log().ifError().extract()
        ;
    }




}
