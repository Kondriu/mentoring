package com.mentoring.ui.google.pages.google;

import com.mentoring.ui.google.pages.BasePage;
import com.mentoring.ui.google.pages.gmail.GoogleAccountsPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GoogleHomePage extends BasePage {
    private static final Logger log = Logger.getLogger(GoogleHomePage.class);

    @FindBy(name = "q")
    private WebElement inputField;

    @FindBy(xpath = "//div[@class='VlcLAe']//input[@name = 'btnK']")
    private WebElement searchButton;

    public GoogleHomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void getGoogleHomePage() {
        visitPage("https://google.com/ncr");
    }

    public void typeSearchRequest(String requestString) {
        log.info("set string to search: " + requestString);
        waitFor(visibilityOf(inputField));
        inputField.sendKeys(requestString);
    }

    public GoogleSearchResultsPage clickOnSearchButton() {
        log.info("Do search...");
        waitFor(visibilityOf(searchButton));
        searchButton.click();
        return new GoogleSearchResultsPage();
    }

}
