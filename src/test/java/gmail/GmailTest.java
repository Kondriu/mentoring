package gmail;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.gmail.AccountsGoogleCom;
import pages.gmail.GmailCom;

import java.util.ArrayList;
import java.util.List;

public class GmailTest extends BaseTest {

    @Test
    public void gmailLoginAndCreateEmailAndSendEmailTest() {

        getDriver().get("https://accounts.google.com");

        AccountsGoogleCom login = new AccountsGoogleCom(getDriver());

        getWait().until(ExpectedConditions.visibilityOf(login.getSetEmailField()));
        login.typeEmail(getPropertiesReader().getEnvironmentValue("user.login"));

        getWait().until(ExpectedConditions.elementToBeClickable(login.getNextButton()));
        login.clickNextButton();

        getWait().until(ExpectedConditions.visibilityOf(login.getSetPasswordField()));
        login.typePassword(getPropertiesReader().getEnvironmentValue("user.passw"));

        getWait().until(ExpectedConditions.visibilityOf(login.getNextButton()));
        login.clickNextButton();

        getWait().until(ExpectedConditions.visibilityOf(login.getGoogleMenuButton()));
        login.expandGoogleMenu();

        getWait().until(ExpectedConditions.visibilityOf(login.getGmailLinkButton()));
        GmailCom gmailCom = login.clickOnGmailLink();

        List<String> listOfBrowserTabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(listOfBrowserTabs.get(1));


        gmailCom.mouseMoveToCreateNewEmailButton();
        getWait().until(ExpectedConditions.elementToBeClickable(gmailCom.getNewEmailButton()));
        gmailCom.clickCreateNewEmail();

        getWait().until(ExpectedConditions.elementToBeClickable(gmailCom.getSendEmailButton()));
        gmailCom.typeReceiversEmail(getPropertiesReader().getEnvironmentValue("email.to"));
        gmailCom.typeSubject(getPropertiesReader().getEnvironmentValue("email.subject"));
        gmailCom.sendEmail();

        getJavascriptExecutor().executeScript("return((window.jQuery != null) && (jQuery.active === 0))").equals("true");
        getWait().until(ExpectedConditions.visibilityOf(gmailCom.getInboxButton()));
        getWait().until(ExpectedConditions.elementToBeClickable(gmailCom.getInboxButton()));
        gmailCom.clickOnInboxButton();

        List<WebElement> listOfUnReadEmailsSubjects = gmailCom.getListEmailsUnRead();

        Assert.assertEquals("Messages Subjects mismatch", getPropertiesReader().getEnvironmentValue("email.subject"), listOfUnReadEmailsSubjects.get(0).getText());

    }
}
