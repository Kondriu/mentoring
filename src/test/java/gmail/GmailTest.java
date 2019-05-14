package gmail;

import common.BaseTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.gmail.AccountsGoogleCom;
import pages.gmail.GmailCom;

public class GmailTest extends BaseTest {

    @Test
    public void getGmailPage() {
        //getDriver().get("https://gmail.com");
        WebDriver driver = getDriver();
        driver.get("https://accounts.google.com");
        AccountsGoogleCom login = new AccountsGoogleCom(getDriver());
        login.typeEmail("dkondriu");
        System.out.println("set login");

        login.clickNextButton();
        System.out.println("click next");


        login.typePassword("mz7bqkkFR");
        System.out.println("set passsw");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(login.getNextButton()));
        login.clickNextButton();
        System.out.println("click next");

        login.expandGoogleMenu();
        System.out.println("expand menu");

        GmailCom gmailCom = login.clickOnGmailLink();
        System.out.println("open gmail");

        wait.until(ExpectedConditions.elementToBeClickable(gmailCom.getNewEmailButton()));
        gmailCom.clickCreateNewEmail();
        System.out.println("click new email");



        gmailCom.typeBodyEmail("kdv.carbon@gmail.com");
        System.out.println("set email");

        gmailCom.typeSubject("Selenium test message");
        System.out.println("set subject");

        gmailCom.typeBodyEmail("Hello world! \n this is message created by Selenium WebDriver");
        System.out.println("set body");

        gmailCom.sendEmail();
        System.out.println("send it");

    }
}
