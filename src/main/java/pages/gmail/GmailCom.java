package pages.gmail;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.util.List;

@Data
public class GmailCom extends BasePage {

    private WebDriver driver;

    @FindBy(css = "div[class=z0]>div")
    private WebElement newEmailButton;

    @FindBy(css = "textarea[name=to]")
    private WebElement emailToField;

    @FindBy(css = "input[name=subjectbox]")
    private WebElement emailSubjField;

    //@FindBy(xpath = "//div[@id=':a1']")
    @FindBy(css = "div[class^=Am]")
    private WebElement emailBodyField;

    @FindBy(css = "div[class^='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private WebElement sendEmailButton;

    @FindBys({
            @FindBy(css = "span[class=bog]>span[class=bqe]")
    })
    private List<WebElement> listEmailsUnRead;

    @FindBy(css = "a[href$='/#inbox']")
    private WebElement inboxButton;

    public GmailCom(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateNewEmail() {
        newEmailButton.click();
    }

    public void typeReceiversEmail(String emailReceiver) {
        emailToField.sendKeys(emailReceiver);
    }

    public void typeSubject(String subj) {
        emailSubjField.sendKeys(subj);
    }

    public void typeBodyEmail(String body) {
        emailBodyField.sendKeys(body);
    }

    public WebElement getSendEmailButton() {
        return sendEmailButton;
    }

    public void sendEmail() {
        sendEmailButton.click();
    }

    public WebElement getNewEmailButton() {
        return newEmailButton;
    }

    public void mouseMoveToCreateNewEmailButton() {
        Actions action = new Actions(driver);
        action.moveToElement(newEmailButton).perform();
    }

    public List<WebElement> getListEmailsUnRead() {
        return listEmailsUnRead;
    }

    public WebElement getInboxButton() {
        return inboxButton;
    }

    public void clickOnInboxButton() {
        inboxButton.click();
    }
}
