
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
    public void testAddTwoArticleAndDeleteOne()
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
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find article",
                5
        );

        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Add this article to a reading list']"),
                "Cannot find option to add article to reading list",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find 'Got it' tip overlay",
                5
        );

        MainPageObject.waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "Cannot find input to set name of articles folder",
                1
        );

        String name_of_folder = "Learning programming";

        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot put text into article folder input",
                1
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot press OK button",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find X link",
                5
        );

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
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='JavaScript']"),
                "Cannot find article",
                5
        );

        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Add this article to a reading list']"),
                "Cannot find option to add article to reading list",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/item_container']//*[@text='Learning programming']"),
                "Cannot find favourite list in popup",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find X link",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find navigation button to my lists",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='"+name_of_folder+"']"),
                "Cannot find created folder",
                5
        );

        MainPageObject.swipeElementToLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find saved article"
        );

        MainPageObject.waitForElementNotPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot delete saved article",
                5
        );

        String title_before_open_article = MainPageObject.waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/page_list_item_title"),
                "text",
                "Cannot find title of article",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='JavaScript']"),
                "Cannot find article",
                5
        );

        String title_after_open_article = MainPageObject.waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "Cannot find title of article",
                15
        );

        Assert.assertEquals(
                "Article title have been changed after opening",
                title_before_open_article,
                title_after_open_article
        );

    }

    @Test
    public void testAssertTitle()
    {
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find Search Wikipedia input",
                5
        );

        String search_line = "Java";

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                search_line,
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by " + search_line,
                15
        );

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/view_page_header_container']//*[@resource-id='org.wikipedia:id/view_page_title_text']";

        MainPageObject.waitForElementPresent(
                By.xpath(search_result_locator),
                "Title are not presented on the page",
                15
                );

        MainPageObject.assertElementPresent(
                By.xpath(search_result_locator),
                " Title displayed incorrect " + search_line
                );
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
    public void testCancelSearch1()
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
                By.xpath("//*[contains(@text, 'Object-oriented programming language')]"),
                "Cannot find search result",
                15
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[contains(@text, 'My java')]"),
                "Cannot find search result",
                15
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[contains(@text, 'Island of Indonesia')]"),
                "Cannot find search result",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find X to cancel search",
                5
        );

        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/fragment_main_container"),
                "Cannot find toolbar",
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[contains(@text, 'Wikipedia')]"),
                "Main page is not presented",
                15
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
