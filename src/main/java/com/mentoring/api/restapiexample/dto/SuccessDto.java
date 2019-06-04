package com.mentoring.api.restapiexample.dto;

public class SuccessDto {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "SuccessDto{" +
                "text='" + text + '\'' +
                '}';
    }
}
