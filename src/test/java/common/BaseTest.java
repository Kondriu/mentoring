package common;

import org.junit.After;
import org.junit.Before;
import utills.EnvironmentPropertiesReader;

import java.io.IOException;

import static pages.BasePage.driver;
import static pages.BasePage.initDriver;

public class BaseTest {

    public EnvironmentPropertiesReader propertiesReader() throws IOException {
        EnvironmentPropertiesReader environmentPropertiesReader = new EnvironmentPropertiesReader();
        return environmentPropertiesReader;
    }

    @Before
    public void startBrowser() {
        initDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
