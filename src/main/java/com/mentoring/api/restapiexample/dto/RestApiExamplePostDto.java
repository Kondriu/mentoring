package com.mentoring.api.restapiexample.dto;

public class RestApiExamplePostDto {

    private String name;
    private Integer id;
    private String salary;
    private String age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "RestApiExamplePostDto{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary='" + salary + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
