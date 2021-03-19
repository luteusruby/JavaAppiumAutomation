package lib.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject{

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    private static final String
        MY_LISTS_LINK = "//android.widget.FrameLayout[@content-desc='My lists']";

    public void clickMyLists()
    {
        this.waitForElementAndClick(
                By.xpath(MY_LISTS_LINK),
                "Cannot find navigation button to my lists",
                5
        );
    }
}
