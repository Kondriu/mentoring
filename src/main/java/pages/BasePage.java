package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver driver;

    public BasePage(final WebDriver driver) {
        this.driver = driver;
    }

    public BasePage() {
    }

    public WebDriver getDriver() {
        return driver;
    }
}
