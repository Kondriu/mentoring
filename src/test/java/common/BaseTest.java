package common;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown(){
        driver.close();
    }
}
