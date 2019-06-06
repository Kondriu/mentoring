package com.mentoring.ui.utills;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties;

    public PropertiesReader() throws IOException {
        String pathToResources = "src/test/resources/ui.resources.properties";
        properties = new Properties();
        properties.load(new FileInputStream(pathToResources));
    }

    public String getValue(final String key) {
        return properties.getProperty(key);
    }
}
