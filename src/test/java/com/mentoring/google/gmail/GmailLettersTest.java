package com.mentoring.google.gmail;

import com.mentoring.google.pages.gmail.GmailPage;
import com.mentoring.google.pages.gmail.GoogleAccountsPage;
import org.junit.Assert;
import org.junit.Test;
import com.mentoring.google.BaseTest;

import java.io.IOException;

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
        String newSubject = gmailPage.createSubject();

        gmailPage.mouseMoveToCreateNewEmailButton();
        gmailPage.clickCreateNewEmail();
        gmailPage.typeReceiversEmail(propertiesReader().getValue("email.to"));
        gmailPage.typeSubject(newSubject);
        gmailPage.sendEmail();
        gmailPage.clickOnInboxButton();

        Assert.assertEquals("Message Subject mismatch", newSubject, gmailPage.getTopSubjectInEmailsList());
    }
}
