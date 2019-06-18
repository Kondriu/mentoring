package com.mentoring.ui.google.pages.google;

import com.mentoring.ui.google.pages.BasePage;
import com.mentoring.ui.google.pages.gmail.GoogleAccountsPage;
import com.mentoring.ui.google.pages.google.objects.SearchResultsItemText;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GoogleSearchResultsPage extends BasePage {

    private static final Logger log = Logger.getLogger(GoogleSearchResultsPage.class);

    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> searchResult;


    public GoogleSearchResultsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public List<SearchResultsItemText> getSearchResultList() {
        log.info("Getting and storing search output");

        List<SearchResultsItemText> itemTexts = new ArrayList<>();

        for (WebElement item : searchResult) {
            SearchResultsItemText resultsItemText = new SearchResultsItemText();

            String head = item.findElement(By.xpath(".//h3")).getText();
            String link = item.findElement(By.xpath(".//cite")).getText();

            resultsItemText.setDescription(head);
            resultsItemText.setUrl(link);
            itemTexts.add(resultsItemText);
        }
        return itemTexts;
    }

    public void clickOnLink(String head) {
        log.info("clicking on link with header: " + head);
        getDriver().get(getSearchResultList()
                .stream()
                .filter(x -> x.getDescription().contentEquals(head))
                .map(SearchResultsItemText::getUrl)
                .collect(Collectors.joining()));
    }

}
