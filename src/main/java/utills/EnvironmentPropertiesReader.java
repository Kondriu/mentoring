package utills;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentPropertiesReader {

    private String pathToResources;
    private Properties properties;

    public EnvironmentPropertiesReader() throws IOException {
        pathToResources = "src/test/resources/resources.properties";
        properties = new Properties();
        properties.load(new FileInputStream(pathToResources));
    }

    public String getEnvironmentValue(final String key) {
        final String value = properties.getProperty(key);
        return value;
    }
}
