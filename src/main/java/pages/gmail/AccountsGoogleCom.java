package pages.gmail;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

@Data
public class AccountsGoogleCom extends BasePage {

    private WebDriver driver;

    @FindBy(css = "input[type=email]")
    private WebElement setEmailField;

    @FindBy(css = "span[class='RveJvd snByac']")
    private WebElement nextButton;

    @FindBy(css = "input[type='password']")
    private WebElement setPasswordField;

    @FindBy(css = "a[class=gb_x]")
    private WebElement googleMenuButton;

    @FindBy(css = "a[href='https://mail.google.com/mail/?tab=km']")
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

    public void expandGoogleMenu() {
        googleMenuButton.click();
    }

    public GmailCom clickOnGmailLink() {
        gmailLinkButton.click();
        return new GmailCom(driver);
    }

}
