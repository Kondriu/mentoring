package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utills.EnvironmentPropertiesReader;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static pages.BasePage.*;

public class BaseTest {


    public EnvironmentPropertiesReader propertiesReader() throws IOException {
        EnvironmentPropertiesReader environmentPropertiesReader = new EnvironmentPropertiesReader();
        return environmentPropertiesReader;
    }

    @Before
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
