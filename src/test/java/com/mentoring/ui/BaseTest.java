package com.mentoring.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import com.mentoring.ui.utills.PropertiesReader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.IOException;

import static com.mentoring.ui.google.pages.BasePage.getDriver;
import static com.mentoring.ui.google.pages.BasePage.setDriver;

public class BaseTest {

    public PropertiesReader propertiesReader() throws IOException {
        return new PropertiesReader();
    }

    @Before
    public void startBrowser() {

        String browserName = System.getProperty("browserName");
        //if (browserName == null) browserName = "chrome";


        System.out.println("++++++++");
        System.out.println("Value of browserName: " + browserName);
        System.out.println("run suite: " + System.getProperty("test"));
        System.out.println("++++++++");

//        WebDriverManager.chromedriver().setup();
//        System.getProperty("browser");

        // вычитывает пармерт из командной строки
        //типа все что идет после mvn
        // clean test -Dbrowser=${browserName}
        // browserName - как назвал в дженкинсе
        // свич кейс в засисмости от вычитанной System.getProperty
        //

        switch (browserName) {
            case ("firefox"): {
                WebDriverManager.firefoxdriver().setup();
                setDriver(new FirefoxDriver());
                getDriver().manage().window().maximize();
            }break;
            case ("opera"): {
                WebDriverManager.operadriver().setup();
                setDriver(new OperaDriver());
                getDriver().manage().window().maximize();
            }break;
            case ("chrome"):
            default:{
                WebDriverManager.chromedriver().setup();
                setDriver(new ChromeDriver());
                getDriver().manage().window().maximize();
            }break;
        }

    }

    @After
    public void tearDown() {
        getDriver().quit();
    }

}
