package com.mentoring.testing_ui.google.pages.gmail;

import com.mentoring.testing_ui.google.pages.BasePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

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
        PageFactory.initElements(getDriver(), this);
    }

    public void mouseMoveToCreateNewEmailButton() {
        waitFor(visibilityOf(newEmailButton));
        mouseMoveTo(newEmailButton);
    }

    public void clickCreateNewEmail() {
        executeJavaScript("return((window.jQuery != null) && (jQuery.active === 0))");
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
        executeJavaScript("return((window.jQuery != null) && (jQuery.active === 0))");
        waitFor(visibilityOf(sendEmailButton));
        waitFor(elementToBeClickable(sendEmailButton));
        sendEmailButton.click();
    }

    public List<WebElement> getListEmailsUnRead() {
        return listEmailsUnRead;
    }

    public void clickOnInboxButton() {
        executeJavaScript("return((window.jQuery != null) && (jQuery.active === 0))");
        waitFor(presenceOfElementLocated(By.cssSelector("a[href$='/#inbox']")));
        waitFor(visibilityOf(inboxButton));
        waitFor(elementToBeClickable(inboxButton));
        inboxButton.click();
    }

    public List<String> listOfUnReadEmailsSubjects() {
        return getListEmailsUnRead().
                stream().
                map(WebElement::getText).
                collect(Collectors.toList());
    }

    public String getTopSubjectInEmailsList() {
        if (!listOfUnReadEmailsSubjects().isEmpty()) {
            return listOfUnReadEmailsSubjects().get(0);
        } else {
            return StringUtils.EMPTY;
        }
    }

    public String createSubject() {
        return String.format("Subject - '%s' ", Calendar.getInstance().getTime()).trim();
    }
}
