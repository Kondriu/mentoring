package com.mentoring.api.restapiexample;

import com.mentoring.api.restapiexample.dto.RestApiExampleDeleteDto;
import com.mentoring.api.restapiexample.dto.RestApiExampleGetDto;
import com.mentoring.api.restapiexample.dto.RestApiExamplePostDto;
import com.mentoring.api.restapiexample.dto.RestApiExamplePutDto;
import com.mentoring.api.utills.PropertiesReader;
import org.junit.Assert;
import org.junit.Test;

public class RestApiExampleTest {

    private RestApiExampleService restapiexampleService = new RestApiExampleService();
    private PropertiesReader propertiesReader = new PropertiesReader();

    private String name;
    private String salary = propertiesReader.getValue("user.salary");
    private String age = propertiesReader.getValue("user.age");

    @Test
    public void testPostRequest() {
        name = restapiexampleService.getGenericName();

        RestApiExamplePostDto response = restapiexampleService.createNewAccount(name, salary, age);
        Assert.assertEquals("Wrong Salary", salary, response.getSalary());
        Assert.assertEquals("Wrong Age", age, response.getAge());
        Assert.assertEquals("Wrong name", name, response.getName());
        Assert.assertNotNull("Id is empty", response.getId());
    }

    @Test
    public void testPutRequest() {
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
        name = restapiexampleService.getGenericName();

        RestApiExamplePostDto response = restapiexampleService.createNewAccount(name, salary, age);
        RestApiExampleDeleteDto deleting = restapiexampleService.deleteAccount(response.getId());

        Assert.assertEquals("Received wrong success-message", "successfully! deleted Records", deleting.getSuccess().getText());
        restapiexampleService.assertAbsentAccount(response.getId());
    }

}
