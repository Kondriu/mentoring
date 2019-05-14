package pages.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import pages.AbstractPage;

import java.util.List;

public class GmailCom extends AbstractPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[contains(text(), 'Написати')]")
    //div[@class='z0']/div
    private WebElement newEmailButton;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement emailToField;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement emailSubjField;

    @FindBy(xpath = "//div[@id=':a1']")
    private WebElement emailBodyField;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//span[@class='gb_ya gbii']")
    private WebElement googleAccountButton;

    @FindBy(xpath = "//a[@class='gb_0 gb_Af gb_If gb_ke gb_kb']")
    private WebElement exitButton;

    @FindBys({
            @FindBy(xpath = "//tr[@class='zA yO']//span[@class='bog']")
    })
    private List<WebElement> listEmails;


    @FindBy(xpath = "//span[@class='nU ']/a[@tabindex = 0]")//a[@href='https://mail.google.com/mail/#inbox']
    private WebElement inboxButton;

    public GmailCom(final WebDriver driver) {
        this.driver = driver;
        //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    public WebElement getSendEmailButton(){
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

    public List<WebElement> getList() {
        return listEmails;
    }

    public WebElement getInboxButton() {
        return inboxButton;
    }

    public void clickOnInboxButton() {
        inboxButton.click();
    }
}
