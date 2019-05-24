package com.mentoring.iu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import com.mentoring.ui.utills.PropertiesReader;

import java.io.IOException;

import static com.mentoring.ui.google.pages.BasePage.getDriver;
import static com.mentoring.ui.google.pages.BasePage.setDriver;

public class BaseTest {

    public PropertiesReader propertiesReader() throws IOException {
        return new PropertiesReader();
    }

    @Before
    public void startBrowser() {

        WebDriverManager.chromedriver().setup();
        setDriver(new ChromeDriver());
        getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        getDriver().quit();
    }

}
