package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    private WebDriver driver;

    public BasePage(final WebDriver driver) {
        this.driver=driver;

    }

    public BasePage() {
    }

    public WebDriver getDriver(){
        return driver;
    }
}
