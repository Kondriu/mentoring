package com.mentoring.api.openweathermap.PropertyMappers;

import junitparams.mappers.CsvWithHeaderMapper;

import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

public class CoordinatesCityMapper extends CsvWithHeaderMapper {

    @Override
    public Object[] map(Reader reader) {
        Object[] map = super.map(reader);
        List<Object[]> result = new LinkedList<>();
        for (Object lineObj : map) {
            String line = (String) lineObj;
            String delimiter = "\\|";

            String[] parsed = line.split(delimiter);

            result.add(new Object[]{
                    parsed[2], parsed[3], parsed[6]

            });
        }
        return result.toArray();
    }
}
