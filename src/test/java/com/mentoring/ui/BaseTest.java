package com.mentoring.ui;

import com.mentoring.ui.utills.PropertiesReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.io.IOException;

import static com.mentoring.ui.google.pages.BasePage.getDriver;
import static com.mentoring.ui.google.pages.BasePage.setDriver;

public class BaseTest {

    public PropertiesReader propertiesReader() throws IOException {
        return new PropertiesReader();
    }

    @Before
    public void startBrowser(){

        String browserName = System.getProperty("browserName");
        if (browserName == null || browserName.isEmpty()) browserName = "chrome";


        switch (browserName) {
            case ("firefox"): {

                WebDriverManager.firefoxdriver().setup();
                setDriver(new FirefoxDriver());
                getDriver().manage().window().maximize();
                break;
            }
            case ("opera"): {

                WebDriverManager.operadriver().setup();

                OperaOptions operaOptions = new OperaOptions();
                operaOptions.addArguments("start-maximized");
                operaOptions.setBinary("/usr/bin/opera");

                setDriver(new OperaDriver(operaOptions));
                break;
            }
            case ("chrome"): {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("disable-infobars");
                setDriver(new ChromeDriver(options));
                break;
            }
        }

    }

    @After
    public void tearDown() {
        getDriver().quit();
    }

}
