package pages.gmail;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.AbstractPage;


public class AccountsGoogleCom extends AbstractPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[contains (@class, 'whsOnd zHQkBf') and @type='email']")
    private WebElement setEmailField;

    @FindBy(xpath = "//div[@class='qhFLie']//span[@class='RveJvd snByac']")
    private WebElement nextButton;


    @FindBy(xpath = "//input[contains (@class, 'whsOnd zHQkBf') and @type='password']")
    private WebElement setPasswordField;

    @FindBy(xpath = "//a[@class='gb_x']")
    private WebElement googleMenuButton;


    @FindBy(xpath = "//a[@href ='https://mail.google.com/mail/?tab=km']")
    private WebElement gmailLinkButton;


    public AccountsGoogleCom(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeEmail(String email) {
        setEmailField.clear();
        setEmailField.sendKeys(email);
    }

    public void typePassword(String passw) {
        setPasswordField.clear();
        setPasswordField.sendKeys(passw);
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    public void expandGoogleMenu() {
        googleMenuButton.click();
    }

    public GmailCom clickOnGmailLink() {
        gmailLinkButton.click();
        return new GmailCom(driver);
    }

}
