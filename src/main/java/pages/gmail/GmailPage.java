package pages.gmail;

import lombok.Data;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@Data
public class GmailPage extends BasePage {

    @FindBy(css = "div[class=z0]>div")
    private WebElement newEmailButton;

    @FindBy(css = "textarea[name=to]")
    private WebElement emailToField;

    @FindBy(css = "input[name=subjectbox]")
    private WebElement emailSubjField;

    @FindBy(css = "div[class^=Am]")
    private WebElement emailBodyField;

    @FindBy(css = "div[class^='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private WebElement sendEmailButton;

    @FindBy(css = "span[class=bog]>span[class=bqe]")
    private List<WebElement> listEmailsUnRead;

    @FindBy(css = "a[href$='/#inbox']")
    private WebElement inboxButton;

    public GmailPage() {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void mouseMoveToCreateNewEmailButton() {
        waitFor(visibilityOf(newEmailButton));
        Actions action = new Actions(driver);
        action.moveToElement(newEmailButton).perform();
    }

    public void clickCreateNewEmail() {
        waitFor(elementToBeClickable(newEmailButton));
        newEmailButton.click();
    }

    public void typeReceiversEmail(String emailReceiver) {
        waitFor(visibilityOf(emailToField));
        emailToField.sendKeys(emailReceiver);
    }

    public void typeSubject(String subj) {
        waitFor(visibilityOf(emailSubjField));
        emailSubjField.sendKeys(subj);
    }

    public void sendEmail() {
        waitFor(visibilityOf(sendEmailButton));
        sendEmailButton.click();
    }

    public List<WebElement> getListEmailsUnRead() {
        waitFor(visibilityOfAllElements(listEmailsUnRead));
        return listEmailsUnRead;
    }

    public void clickOnInboxButton() {
        waitJsExecutor();
        waitFor(visibilityOf(inboxButton));
        waitFor(elementToBeClickable(inboxButton));
        inboxButton.click();
    }

    public List<String> listOfUnReadEmailsSubjects() {
        List<String> listOfUnReadEmailsSubjectsStrings = getListEmailsUnRead().
                stream().
                map(x -> x.getText()).
                collect(Collectors.toList());
        return listOfUnReadEmailsSubjectsStrings;
    }

    public String getTopSubjectInEmailsList() {
        return listOfUnReadEmailsSubjects().get(0);
    }
}
