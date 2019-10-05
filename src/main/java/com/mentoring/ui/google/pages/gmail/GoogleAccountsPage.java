package com.mentoring.ui.google.pages.gmail;

import com.mentoring.ui.google.pages.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class GoogleAccountsPage extends BasePage {

    @FindBy(css = "input[type=email]")
    private WebElement setEmailField;

    @FindBy(css = "span[class='RveJvd snByac']")
    private WebElement nextButton;

    @FindBy(css = "input[type='password']")
    private WebElement setPasswordField;

    @FindBy(css = "svg[class^=gb_]")
    private WebElement googleMenuButton;

    @FindBy(css = "a[href^='https://mail.google.com/mail/']")
    private WebElement      gmailLinkButton;

    private static final Logger log = Logger.getLogger(GoogleAccountsPage.class);

    public GoogleAccountsPage() {
        PageFactory.initElements(getDriver(), this);
    }


    public void typeEmail(String email) {
        log.info("Set email: " + email);
        waitFor(visibilityOf(setEmailField));
        setEmailField.clear();
        setEmailField.sendKeys(email);
    }

    public void typePassword(String password) {
        log.info("Set password:");
        executeJavaScript("return document.readyState");
        waitFor(visibilityOf(setPasswordField));
        setPasswordField.clear();
        setPasswordField.sendKeys(password);
    }

    public void clickNextButton() {
        log.info("click in \"Next\" button");
        waitFor(visibilityOf(nextButton));
        nextButton.click();
    }

    public void expandGoogleMenu() {
        log.info("expand  \"Google Menu\"");
        waitFor(visibilityOf(googleMenuButton));
        googleMenuButton.click();
    }

    public GmailPage clickOnGmailLink() {
        log.info("click on \"Gmail\" ling");
        executeJavaScript("return document.readyState");
        waitFor(visibilityOf(gmailLinkButton));
        gmailLinkButton.click();
        return new GmailPage();
    }

}
