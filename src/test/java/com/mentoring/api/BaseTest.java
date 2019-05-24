package com.mentoring.api;

import com.mentoring.api.utills.PropertiesReader;
import org.apache.log4j.Logger;

public class BaseTest {

    public static final Logger log = Logger.getLogger(BaseTest.class);

    public static PropertiesReader propertiesReader(){
        return new PropertiesReader();
    }

}
