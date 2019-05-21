package utills;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentPropertiesReader {

    private Properties properties;

    public EnvironmentPropertiesReader() throws IOException {
        String pathToResources = "src/test/resources/resources.properties";
        properties = new Properties();
        properties.load(new FileInputStream(pathToResources));
    }

    public String getValue(final String key) {
        return properties.getProperty(key);
    }
}
