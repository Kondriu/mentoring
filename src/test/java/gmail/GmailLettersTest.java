package gmail;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.gmail.GoogleAccountsPage;
import pages.gmail.GmailPage;

import java.io.IOException;

public class GmailLettersTest extends BaseTest {

    @Test
    public void testGmailLoginAndCreateEmailAndSendEmail() throws IOException {

        GoogleAccountsPage accountsPage = new GoogleAccountsPage();

        accountsPage.visitPage(propertiesReader().getValue("google.accounts.page.uri"));
        accountsPage.typeEmail(propertiesReader().getValue("user.login"));
        accountsPage.clickNextButton();
        accountsPage.typePassword(propertiesReader().getValue("user.passw"));
        accountsPage.clickNextButton();
        accountsPage.expandGoogleMenu();

        GmailPage gmailPage = accountsPage.clickOnGmailLink();
        gmailPage.switchToBrowserTab(1);

        Integer countExistUnreaded = gmailPage.getListEmailsUnRead().size();

        gmailPage.mouseMoveToCreateNewEmailButton();
        gmailPage.clickCreateNewEmail();
        gmailPage.typeReceiversEmail(propertiesReader().getValue("email.to"));
        gmailPage.typeSubject(propertiesReader().getValue("email.subject"));
        gmailPage.sendEmail();
        gmailPage.clickOnInboxButton();

        Integer countUnreadedAfterTest = gmailPage.getListEmailsUnRead().size();

        Assert.assertTrue("Did not added any new email...", countUnreadedAfterTest > countExistUnreaded);
        Assert.assertEquals("Message Subject mismatch", propertiesReader().getValue("email.subject"), gmailPage.getTopSubjectInEmailsList());

    }
}
