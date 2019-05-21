package pages.google;

import org.junit.Assert;
import org.junit.Test;
import pages.BaseTest;

import java.io.IOException;
import java.util.Calendar;

public class GmailLettersTest extends BaseTest {

    @Test
    public void testGmailLoginAndCreateEmailAndSendEmail() throws IOException {

        GoogleAccountsPage accountsPage = new GoogleAccountsPage();

        accountsPage.visitPage(propertiesReader().getValue("google.accounts.page.uri"));
        accountsPage.typeEmail(propertiesReader().getValue("user.login"));
        accountsPage.clickNextButton();
        accountsPage.typePassword(propertiesReader().getValue("user.password"));
        accountsPage.clickNextButton();
        accountsPage.expandGoogleMenu();

        GmailPage gmailPage = accountsPage.clickOnGmailLink();
        gmailPage.switchToBrowserTab(1);

        gmailPage.mouseMoveToCreateNewEmailButton();
        gmailPage.clickCreateNewEmail();
        gmailPage.typeReceiversEmail(propertiesReader().getValue("email.to"));
        String newSubject = String.format("Subject - " + propertiesReader().getValue("email.subject") + " '%s' ", Calendar.getInstance().getTime());
        gmailPage.typeSubject(newSubject);
        gmailPage.sendEmail();

        gmailPage.clickOnInboxButton();

        Assert.assertEquals("Message Subject mismatch", newSubject.trim(), gmailPage.getTopSubjectInEmailsList().trim());

    }
}
