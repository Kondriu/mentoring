package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utills.EnvironmentPropertiesReader;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private EnvironmentPropertiesReader environmentPropertiesReader;

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {return wait;}

    public EnvironmentPropertiesReader getPropertiesReader(){return environmentPropertiesReader;}

    @Before
    public void initDriver() throws IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        environmentPropertiesReader = new EnvironmentPropertiesReader();
        wait = new WebDriverWait(getDriver(), 20);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
