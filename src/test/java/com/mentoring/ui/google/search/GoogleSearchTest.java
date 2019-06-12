package com.mentoring.ui.google.search;

import com.mentoring.ui.BaseTest;
import com.mentoring.ui.google.pages.google.GoogleHomePage;
import com.mentoring.ui.google.pages.google.GoogleSearchResultsPage;
import org.junit.Assert;
import org.junit.Test;

import static com.mentoring.ui.google.pages.BasePage.getDriver;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void testSearchingForSelenium() {
        String siteTitle = "Selenium - Web Browser Automation";
        GoogleHomePage googleHomePage = new GoogleHomePage();
        googleHomePage.getGoogleHomePage();
        googleHomePage.typeSearchRequest("Selenium");
        GoogleSearchResultsPage searchResultsPage = googleHomePage.clickOnSearchButton();

        searchResultsPage.clickOnLink(siteTitle);
        Assert.assertEquals("Wrong page opened", siteTitle+"uio", getDriver().getTitle());
    }
}
