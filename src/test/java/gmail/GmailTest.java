package gmail;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.gmail.AccountsGoogleCom;
import pages.gmail.GmailCom;
import utills.EnvironmentPropertiesReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GmailTest extends BaseTest {

    @Test
    public void getGmailPage() throws IOException {

        EnvironmentPropertiesReader environmentPropertiesReader = new EnvironmentPropertiesReader();
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);

        getDriver().get("https://accounts.google.com");

        AccountsGoogleCom login = new AccountsGoogleCom(getDriver());
        login.typeEmail(environmentPropertiesReader.getEnvironmentValue("user.login"));

        wait.until(ExpectedConditions.elementToBeClickable(login.getNextButton()));
        login.clickNextButton();

        login.typePassword(environmentPropertiesReader.getEnvironmentValue("user.passw"));

        wait.until(ExpectedConditions.visibilityOf(login.getNextButton()));
        wait.until(ExpectedConditions.elementToBeClickable(login.getNextButton()));
        login.clickNextButton();

        login.expandGoogleMenu();
        GmailCom gmailCom = login.clickOnGmailLink();

        List<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));


        gmailCom.mouseMoveToCreateNewEmailButton();
        wait.until(ExpectedConditions.elementToBeClickable(gmailCom.getNewEmailButton()));
        gmailCom.clickCreateNewEmail();

        wait.until(ExpectedConditions.elementToBeClickable(gmailCom.getSendEmailButton()));
        gmailCom.typeReceiversEmail(environmentPropertiesReader.getEnvironmentValue("email.to"));
        gmailCom.typeSubject(environmentPropertiesReader.getEnvironmentValue("email.subject"));
        gmailCom.sendEmail();

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("return((window.jQuery != null) && (jQuery.active === 0))").equals("true");
        wait.until(ExpectedConditions.visibilityOf(gmailCom.getInboxButton()));
        wait.until(ExpectedConditions.elementToBeClickable(gmailCom.getInboxButton()));
        gmailCom.clickOnInboxButton();

        List<WebElement> listUnReadEmailsSubjects = gmailCom.getListEmailsUnRead();

        listUnReadEmailsSubjects.
                stream().
                map(x -> x.getText()).
                forEach(System.out::println);

        Assert.assertEquals("Messages Subjects mismatch", environmentPropertiesReader.getEnvironmentValue("email.subject"), listUnReadEmailsSubjects.get(0).getText());

    }
}
