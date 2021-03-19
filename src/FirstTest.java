
import lib.CoreTestCase;
import lib.UI.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class FirstTest extends CoreTestCase {

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception
    {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    

    @Test
    public void testCompareTextInField()
    {
        MainPageObject.assertElementHasText(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Search Wikipedia",
                "Cannot find text"
        );
    }



    @Test
    public void testSearchResult()
    {
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find Search Wikipedia input",
                5
        );

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@resource-id='org.wikipedia:id/page_list_item_title']"),
                "Cannot find 'Object-oriented programming language' topic searching by Java",
                15
        );

        MainPageObject.assertElementHasText(
                By.xpath("[@resource-id='org.wikipedia:id/page_list_item_title'][@instance='2']"),
                "Java",
                "No Java text in result"
        );

    }



}
