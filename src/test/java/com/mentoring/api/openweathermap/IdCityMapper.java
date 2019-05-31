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
//            System.out.println(
//                    line.substring(line.indexOf("|",1)+1, line.indexOf("|", (line.indexOf("|",1)+1)))
//            );
            result.add(new Object[]{
                    line.substring(line.indexOf("|",1)+1, line.indexOf("|", (line.indexOf("|",1)+1)))

            });
        }
        return result.toArray();
    }

}
