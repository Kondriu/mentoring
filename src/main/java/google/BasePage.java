package google;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.Configuration;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    private static WebDriver driver;

    public BasePage(final WebDriver driver) {
        setDriver(driver);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver Webdriver) {
        driver = Webdriver;
    }

    public static void waitFor(ExpectedCondition<?> condition) {
        (new WebDriverWait(getDriver(), Configuration.TIMEOUT)).until(condition);
    }


    public void visitPage(String uri) {
        getDriver().get(uri);
    }

    public void switchToBrowserTab(Integer tabIndex) {
        List<String> listOfBrowserTabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(listOfBrowserTabs.get(tabIndex));
    }

    public void executeJavaScript(String script) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript(script).equals("true");
    }
}
