package com.mentoring.api.restapiexample;

import com.mentoring.api.restapiexample.dto.RestApiExampleDeleteDto;
import com.mentoring.api.restapiexample.dto.RestApiExampleGetDto;
import com.mentoring.api.restapiexample.dto.RestApiExamplePostDto;
import com.mentoring.api.restapiexample.dto.RestApiExamplePutDto;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import java.util.Date;

public class RestApiExampleService {

    private static final Logger log = Logger.getLogger(RestApiExampleService.class);

    private static final String URI = "http://dummy.restapiexample.com/api/v1/";
    private static final String CREATE_ACCOUNT_URL = "/create";
    private static final String UPDATE_ACCOUNT_URL = "/update/";
    private static final String DELETE_ACCOUNT_URL = "/delete/";
    private static final String GET_ACCOUNT_DETAILS = "/employee/";


    public RestApiExampleService() {
        RestAssured.baseURI = URI;
        RestAssured.registerParser("text/html", Parser.JSON);
    }


    public String getGenericName() {
        return String.format("Generic Name %1$TH%1$TM%1$TS", new Date());
    }

    public Response makeGetRequestById(Integer id) {
        String getUser = GET_ACCOUNT_DETAILS + id;

        return RestAssured
                .given()
                .get(getUser);
    }

    public RestApiExampleGetDto getUserInfo(Integer id) {
        log.info(String.format("get account details by GET request (id: %s)", id));
        return makeGetRequestById(id)
                .as(RestApiExampleGetDto.class);
    }

    public RestApiExamplePostDto createNewAccount(String name, String salary, String age) {
        log.info(String.format("create new account by POST request  \nname: %S \nsalary: %S\nage: %s", name, salary, age));

        return RestAssured
                .given()
                .request().header("Content-Type", "application/json")
                .request().body(createRequestBody(name, salary, age).toJSONString())
                .request().post(CREATE_ACCOUNT_URL).getBody().as(RestApiExamplePostDto.class);
    }

    public RestApiExamplePutDto updateAccount(Integer id, String name, String salary, String age) {
        log.info(String.format("update account by PUT request \nid: %s, \nname: %S \nsalary: %S\nage: %s", id, name, salary, age));

        String putUrl = UPDATE_ACCOUNT_URL + id;
        return RestAssured
                .given()
                .request().header("Content-Type", "application/json")
                .request().body(createRequestBody(name, salary, age).toJSONString())
                .request().put(putUrl)
                .getBody().as(RestApiExamplePutDto.class);
    }

    public RestApiExampleDeleteDto deleteAccount(Integer id) {
        log.info(String.format("delete account by DELETE request (id: %s)", id));

        String deleteUrl = DELETE_ACCOUNT_URL + id;
        return RestAssured
                .given()
                .delete(deleteUrl)
                .as(RestApiExampleDeleteDto.class);
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
