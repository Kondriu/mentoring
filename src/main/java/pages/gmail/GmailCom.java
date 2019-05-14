package pages.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class GmailCom {

    @FindBy(xpath = "//div[@class='z0']/div")
    private WebElement newEmailButton;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement emailToField;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement emailSubjField;

    @FindBy(xpath = "//div[@id=':a1']")
    private WebElement emailBodyField;

    @FindBy(xpath = "//div[@id=':8m']")
    private WebElement sendEmailButton;


    private WebDriver driver;

    public GmailCom(final WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }


    public void clickCreateNewEmail(){
        newEmailButton.click();
    }

    public void typeReceiversEmail(String emailReceiver){
        emailToField.sendKeys(emailReceiver);
    }

    public void typeSubject(String subj){
        emailSubjField.sendKeys(subj);
    }

    public void typeBodyEmail(String body){
        emailBodyField.sendKeys(body);
    }

    public void sendEmail(){
        sendEmailButton.click();
    }

    public WebElement getNewEmailButton(){
        return newEmailButton;
    }


}
