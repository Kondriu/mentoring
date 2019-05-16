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
    public void gmailLoginAndCreateEmailAndSendEmailTest(){

        getDriver().get("https://accounts.google.com");

        AccountsGoogleCom login = new AccountsGoogleCom(getDriver());
        login.typeEmail(getPropertiesReader().getEnvironmentValue("user.login"));

        getWait().until(ExpectedConditions.elementToBeClickable(login.getNextButton()));
        login.clickNextButton();

        login.typePassword(getPropertiesReader().getEnvironmentValue("user.passw"));

        getWait().until(ExpectedConditions.visibilityOf(login.getNextButton()));
        getWait().until(ExpectedConditions.elementToBeClickable(login.getNextButton()));
        login.clickNextButton();

        login.expandGoogleMenu();
        GmailCom gmailCom = login.clickOnGmailLink();

        List<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));


        gmailCom.mouseMoveToCreateNewEmailButton();
        getWait().until(ExpectedConditions.elementToBeClickable(gmailCom.getNewEmailButton()));
        gmailCom.clickCreateNewEmail();

        getWait().until(ExpectedConditions.elementToBeClickable(gmailCom.getSendEmailButton()));
        gmailCom.typeReceiversEmail(getPropertiesReader().getEnvironmentValue("email.to"));
        gmailCom.typeSubject(getPropertiesReader().getEnvironmentValue("email.subject"));
        gmailCom.sendEmail();

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("return((window.jQuery != null) && (jQuery.active === 0))").equals("true");
        getWait().until(ExpectedConditions.visibilityOf(gmailCom.getInboxButton()));
        getWait().until(ExpectedConditions.elementToBeClickable(gmailCom.getInboxButton()));
        gmailCom.clickOnInboxButton();

        List<WebElement> listUnReadEmailsSubjects = gmailCom.getListEmailsUnRead();
        Assert.assertEquals("Messages Subjects mismatch", getPropertiesReader().getEnvironmentValue("email.subject"), listUnReadEmailsSubjects.get(0).getText());

    }
}
