package com.mentoring.ui.google.pages.gmail;

import com.mentoring.ui.google.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GoogleAccountsPage extends BasePage {

    @FindBy(css = "input[type=email]")
    private WebElement setEmailField;

    @FindBy(css = "span[class='RveJvd snByac']")
    private WebElement nextButton;

    @FindBy(css = "input[type='password']")
    private WebElement setPasswordField;

    @FindBy(css = "a[class=gb_x]")
    private WebElement googleMenuButton;

    @FindBy(css = "a[href='https://mail.google.com/mail/?tab=km']")
    private WebElement gmailLinkButton;

    public GoogleAccountsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void typeEmail(String email) {
        waitFor(visibilityOf(setEmailField));
        setEmailField.clear();
        setEmailField.sendKeys(email);
    }

    public void typePassword(String passw) {
        waitFor(visibilityOf(setPasswordField));
        setPasswordField.clear();
        setPasswordField.sendKeys(passw);
    }

    public void clickNextButton() {
        waitFor(visibilityOf(nextButton));
        nextButton.click();
    }

    public void expandGoogleMenu() {
        waitFor(visibilityOf(googleMenuButton));
        googleMenuButton.click();
    }

    public GmailPage clickOnGmailLink() {
        waitFor(visibilityOf(gmailLinkButton));
        gmailLinkButton.click();
        return new GmailPage();
    }

}
