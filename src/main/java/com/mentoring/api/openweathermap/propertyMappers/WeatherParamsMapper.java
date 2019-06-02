package com.mentoring.api.openweathermap.propertyMappers;

import junitparams.mappers.CsvWithHeaderMapper;

import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

public class WeatherParamsMapper extends CsvWithHeaderMapper {

    @Override
    public Object[] map(Reader reader) {
        Object[] map = super.map(reader);
        List<Object[]> result = new LinkedList<>();
        for (Object lineObj : map) {
            String line = (String) lineObj;
            String delimiter = "\\|";
            String[] parsedParameter = line.split(delimiter);
            result.add(new Object[] { parsedParameter[0], parsedParameter[1], parsedParameter[2],
                    parsedParameter[3], parsedParameter[4], parsedParameter[5], parsedParameter[6],
                    parsedParameter[7]});
        }
        return result.toArray();
    }
}
