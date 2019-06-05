package com.mentoring.api.restapiexample;

import com.mentoring.api.restapiexample.dto.RestApiExampleDeleteDto;
import com.mentoring.api.restapiexample.dto.RestApiExampleGetDto;
import com.mentoring.api.restapiexample.dto.RestApiExamplePostDto;
import com.mentoring.api.restapiexample.dto.RestApiExamplePutDto;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestApiExampleService {

    private static final Logger log = Logger.getLogger(RestApiExampleService.class);

    private final String URI = "http://dummy.restapiexample.com/api/v1/";
    private final String CREATE_ACCOUNT_URL = "/create";
    private final String UPDATE_ACCOUNT_URL = "/update/";
    private final String DELETE_ACCOUNT_URL = "/delete/";
    private final String GET_ACCOUNT_DETAILS = "/employee/";


    public RestApiExampleService() {
        RestAssured.baseURI = URI;
        RestAssured.registerParser("text/html", Parser.JSON);
    }


    public String getGenericName() {
        return String.format("Generic Name %1$TH%1$TM%1$TS", new Date());
    }

    public RestApiExampleGetDto getUserInfo(Integer id) {
        log.info("get account details by GET_ACCOUNT_DETAILS request");

        String getUser = GET_ACCOUNT_DETAILS + id;
        return RestAssured
                .given()
                .log().uri()
                .get(getUser)
                .as(RestApiExampleGetDto.class);
    }

    public RestApiExamplePostDto createNewAccount(String name, String salary, String age) {
        log.info("create new account by CREATE_ACCOUNT_URL request");

        return RestAssured
                .given()
                .log().uri()
                .log().body()
                .request().header("Content-Type", "application/json")
                .request().body(createRequestBody(name, salary, age).toJSONString())
                .request().post(CREATE_ACCOUNT_URL).getBody().as(RestApiExamplePostDto.class);
    }

    public RestApiExamplePutDto updateAccount(Integer id, String name, String salary, String age) {
        log.info("create account by UPDATE_ACCOUNT_URL request");

        String putUrl = UPDATE_ACCOUNT_URL + id;
        return RestAssured
                .given()
                .log().uri()
                .log().body()
                .request().header("Content-Type", "application/json")
                .request().body(createRequestBody(name, salary, age).toJSONString())
                .request().put(putUrl)
                .getBody().as(RestApiExamplePutDto.class);
    }

    public RestApiExampleDeleteDto deleteAccount(Integer id) {
        log.info("create account by DELITE request");

        String deleteUrl = DELETE_ACCOUNT_URL + id;
        return RestAssured
                .given()
                .log().uri()
                .delete(deleteUrl)
                .as(RestApiExampleDeleteDto.class);
    }

    public void assertAbsentAccount(Integer id) {
        List<RestApiExampleGetDto> responseList = new ArrayList<>();
        try {
            responseList.add(getUserInfo(id));
        } catch (Exception e) {
            e.getMessage();
        } finally {
            Assert.assertTrue("Account was not deleted", responseList.isEmpty());
        }
    }

    @SuppressWarnings("unchecked")
    private JSONObject createRequestBody(String name, String salary, String age) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("salary", salary);
        requestBody.put("age", age);
        return requestBody;
    }
}
