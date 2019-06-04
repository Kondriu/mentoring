package com.mentoring.api.restapiexample;

import com.mentoring.api.restapiexample.dto.RestApiExampleDeleteDto;
import com.mentoring.api.restapiexample.dto.RestApiExampleGetDto;
import com.mentoring.api.restapiexample.dto.RestApiExamplePostDto;
import com.mentoring.api.restapiexample.dto.RestApiExamplePutDto;
import com.mentoring.api.utills.PropertiesReader;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestApiExampleService {


    private PropertiesReader propertiesReader = new PropertiesReader();

    private final String URI = propertiesReader.getValue("RestApiExample.base.uri");
    private final String POST = propertiesReader.getValue("RestApiExample.post");
    private final String PUT = propertiesReader.getValue("RestApiExample.put");
    private final String DELETE = propertiesReader.getValue("RestApiExample.delete");
    private final String GET = propertiesReader.getValue("RestApiExample.get");


    public String getGenericName() {
        return String.format("Generic Name %1$TH%1$TM%1$TS", new Date());
    }

    public RestApiExampleService() {
        RestAssured.baseURI = URI;
        RestAssured.registerParser("text/html", Parser.JSON);
    }


    public JSONObject createRequestBody(String name, String salary, String age) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("salary", salary);
        requestBody.put("age", age);
        return requestBody;
    }

    public RestApiExampleGetDto getUserInfo(Integer id) {
        String getUser = GET + id;
        return RestAssured
                .given()
                .log().uri()
                .get(getUser)
                .as(RestApiExampleGetDto.class)
                ;
    }

    @SuppressWarnings("unchecked")
    public RestApiExamplePostDto createNewAccount(String name, String salary, String age) {
        return RestAssured
                .given()
                .log().uri()
                .log().body()
                .request().header("Content-Type", "application/json")
                .request().body(createRequestBody(name, salary, age).toJSONString())
                .request().post(POST).getBody().as(RestApiExamplePostDto.class)
                ;
    }

    public RestApiExamplePutDto updateAccount(int id, String name, String salary, String age) {
        String putUrl = PUT + id;
        return RestAssured
                .given()
                .log().uri()
                .log().body()
                .request().header("Content-Type", "application/json")
                .request().body(createRequestBody(name, salary, age).toJSONString())
                .request().put(putUrl)
                .getBody().as(RestApiExamplePutDto.class)
                ;
    }

    public RestApiExampleDeleteDto deleteAccount(Integer id) {
        String deleteUrl = DELETE + id;
        return RestAssured
                .given()
                .log().uri()
                .delete(deleteUrl)
                .as(RestApiExampleDeleteDto.class)
                ;

    }

    public void assertAbsentAccount(int id) {
        List<RestApiExampleGetDto> responseList = new ArrayList<>();
        try {
            responseList.add(getUserInfo(id));
        } catch (Exception e) {
            e.getMessage();
        } finally {
            Assert.assertTrue("Account was not deleted", responseList.isEmpty());
        }
    }
}
