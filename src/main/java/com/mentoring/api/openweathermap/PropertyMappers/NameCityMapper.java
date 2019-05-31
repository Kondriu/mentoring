package com.mentoring.api.openweathermap.PropertyMappers;

import junitparams.mappers.CsvWithHeaderMapper;

import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

public class NameCityMapper extends CsvWithHeaderMapper {

    @Override
    public Object[] map(Reader reader) {
        Object[] map = super.map(reader);
        List<Object[]> result = new LinkedList<>();
        for (Object lineObj : map) {
            String line = (String) lineObj;
            String delimiter = "\\|";

            String[] parsed = line.split(delimiter);

            result.add(new Object[]{
                    parsed[1]

            });
        }
        return result.toArray();
    }
}