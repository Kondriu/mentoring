package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.WebDriverSettings;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;

    public BasePage(final WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void waitFor(ExpectedCondition condition) {
        (new WebDriverWait(driver, WebDriverSettings.TIMEOUT)).until(condition);
    }

    public void visitPage(String uri) {
        driver.get(uri);
    }

    public void switchToBrowserTab(Integer tabIndex) {
        List<String> listOfBrowserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(listOfBrowserTabs.get(tabIndex));
    }

    public void waitJsExecutor() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("return((window.jQuery != null) && (jQuery.active === 0))").equals("true");

    }
}
