package tests;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class SearchTest extends CoreTestCase {

    @Test
    public void testFindJava() {
        MainPageObject mainPO = new MainPageObject(this.driver);

        WebElement skip = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/fragment_onboarding_skip_button",
                "Cannot find skip button");
        skip.click();

        WebElement searchInit = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_container",
                "Cannot find Search Wikipedia init search input");
        searchInit.click();

        WebElement searchInput = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_src_text",
                "Cannot find Search input");
        searchInput.sendKeys("Java");

        WebElement expectedResult = mainPO.waitForElementPresent(
                "xpath://*[./*[contains(@text, 'Island in Indonesia')]]",
                "Cannot find result 'Island in Indonesia'");
        expectedResult.click();
    }

    @Test
    public void testElementDoesntExist() {
        MainPageObject mainPO = new MainPageObject(this.driver);

        WebElement skip = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/fragment_onboarding_skip_button",
                "Cannot find skip button");
        skip.click();

        WebElement searchInit = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_container",
                "Cannot find Search Wikipedia init search input");
        searchInit.click();

        WebElement searchInput = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_src_text",
                "Cannot find Search input");
        searchInput.sendKeys("wfewfewfwegweg");

        String result = mainPO.waitForElementAndGetAttribute(
                "id:org.wikipedia:id/results_text",
                "text",
                "Cannot find attribute",
                Duration.ofSeconds(30));
        if (result.equals("No results")) {
            System.out.println("There are no such results in wikipedia");
        } else {
            System.out.println("Test error");
        }
    }

}