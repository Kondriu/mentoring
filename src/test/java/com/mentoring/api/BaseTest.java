package com.mentoring.api;

import com.mentoring.api.utills.PropertiesReader;
import io.restassured.RestAssured;
import org.junit.Before;

public class BaseTest {


    public static PropertiesReader propertiesReader() {
        return new PropertiesReader();
    }

    @Before
    public void startupSetup() {
        RestAssured.baseURI = propertiesReader().getValue("openweather.uri");
    }
}
