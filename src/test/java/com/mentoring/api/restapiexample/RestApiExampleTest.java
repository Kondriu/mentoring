package com.mentoring.api.restapiexample;

import com.mentoring.api.restapiexample.dto.RestApiExampleDeleteDto;
import com.mentoring.api.restapiexample.dto.RestApiExampleGetDto;
import com.mentoring.api.restapiexample.dto.RestApiExamplePostDto;
import com.mentoring.api.restapiexample.dto.RestApiExamplePutDto;
import com.mentoring.api.utills.PropertiesReader;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class RestApiExampleTest {

    private static final Logger log = Logger.getLogger(RestApiExampleService.class);

    RestApiExampleService restapiexampleService = new RestApiExampleService();
    PropertiesReader propertiesReader = new PropertiesReader();

    String name;
    String salary = propertiesReader.getValue("user.salary");
    String age = propertiesReader.getValue("user.age");

    @Test
    public void testPostRequest() {
        log.info("perform test \"POST request\"");
        name = restapiexampleService.getGenericName();

        RestApiExamplePostDto response = restapiexampleService.createNewAccount(name, salary, age);
        Assert.assertEquals("Wrong Salary", salary, response.getSalary());
        Assert.assertEquals("Wrong Age", age, response.getAge());
        Assert.assertEquals("Wrong name", name, response.getName());
        Assert.assertNotNull("Id is empty", response.getId());


    }

    @Test
    public void testPutRequest() {
        log.info("perform test \"PUT request\"");

        name = restapiexampleService.getGenericName();
        String newSalary = "1100";

        RestApiExamplePostDto response = restapiexampleService.createNewAccount(name, salary, age);
        RestApiExamplePutDto update = restapiexampleService.updateAccount(response.getId(), name, newSalary, age);
        RestApiExampleGetDto check = restapiexampleService.getUserInfo(response.getId());

        Assert.assertEquals("Checking wrong account", name, check.getEmployee_name());
        Assert.assertEquals("Parameter \"salary\" was not updated!", update.getSalary(), check.getEmployee_salary());
    }

    @Test
    public void testDeleteRequest() {
        log.info("perform test \"DELETE request\"");

        name = restapiexampleService.getGenericName();

        RestApiExamplePostDto response = restapiexampleService.createNewAccount(name, salary, age);
        RestApiExampleDeleteDto deleting = restapiexampleService.deleteAccount(response.getId());

        Assert.assertEquals("Received wrong success-message", "successfully! deleted Records", deleting.getSuccess().getText());
        restapiexampleService.assertAbsentAccount(response.getId());


    }

}
