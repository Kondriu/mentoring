package com.mentoring.ui.google.pages.gmail;

import com.mentoring.ui.google.pages.BasePage;
import com.mentoring.ui.google.pages.gmail.objects.SearchResultsItemText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GoogleSearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> searchResult;


    public GoogleSearchResultsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public List<SearchResultsItemText> getSearchResultList() {

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
        String string = getSearchResultList()
                .stream()
                .filter(
                        x -> x.getDescription()
                                .contentEquals(head))
                .map(SearchResultsItemText::getUrl)
                .collect(Collectors.joining());
        getDriver().get(string);

    }

}
