package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class AbstractPage {

    private WebDriver driver;

    public AbstractPage (final WebDriver driver) {
        this.driver=driver;

    }

    public AbstractPage() {
    }

    public WebDriver getDriver(){
        return driver;
    }
}
