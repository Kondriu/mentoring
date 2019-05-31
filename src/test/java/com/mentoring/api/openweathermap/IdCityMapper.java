package com.mentoring.api.openweathermap;

import junitparams.mappers.CsvWithHeaderMapper;

import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

public class IdCityMapper extends CsvWithHeaderMapper {

    @Override
    public Object[] map(Reader reader) {
        Object[] map = super.map(reader);
        List<Object[]> result = new LinkedList<>();
        for (Object lineObj : map) {
            String line = (String) lineObj;
            result.add(new Object[]{
                    line.substring(0, line.indexOf("|")),
                            line.substring(line.indexOf("|")+1)
            });
        }
        return result.toArray();
    }

}
