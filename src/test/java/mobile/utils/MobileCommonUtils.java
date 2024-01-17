package mobile.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class MobileCommonUtils {


    static int waitOptionsDuration = Integer.parseInt(ConfigReader.getProperty("waitOptionsDuration"));

    /**
     * Table items are data table from feature
     *
     * @param tableItems
     * @param elements
     */
    public static void assertTextForTwoLists(DataTable tableItems, List<WebElement> elements) {
        for (int i = 0; i < elements.size(); i++) {
            Assert.assertEquals(tableItems.asList().get(i), elements.get(i).getText());
        }
    }


    /**
     * @param driver
     * @param androidElement
     */
    public static void tapByElement(AndroidDriver driver, WebElement androidElement) {
        touchAction(driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(androidElement))).perform();
    }

    /**
     * driver is AndroidDriver
     * visibleText is the text you would like to scroll to and click
     *
     * @param driver
     * @param visibleText
     */


    /**
     * driver is AndroidDriver
     * visibleText is the text you would like to scroll to and click
     *
     * @param driver

     */


    //Tap by coordinates
    public static void tapByCoordinates(AndroidDriver driver, int x, int y) {
        touchAction(driver)
                .tap(point(x, y))
                .waitAction(waitOptions(ofSeconds(waitOptionsDuration))).perform();
    }

    //Press by element
    public static void pressByElement(AndroidDriver driver, WebElement element, long seconds) {
        touchAction(driver)
                .press(element(element))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }



    //Press by coordinates
    public static void pressByCoordinates(AndroidDriver driver, int x, int y, long seconds) {
        new TouchAction(driver)
                .press(point(x, y))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }

    //Horizontal Swipe by percentages
    public static void horizontalSwipeByPercentage(AndroidDriver driver, double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize(); // gets size of screen
        int anchor = (int) (size.height * anchorPercentage); //
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
        new TouchAction(driver)
                .press(point(startPoint, anchor))
                .waitAction(waitOptions(ofSeconds(waitOptionsDuration)))
                .moveTo(point(endPoint, anchor))
                .release().perform();
    }

    public static void horizontalSwipeByCoordinates(AndroidDriver driver, int xStart, int xEnd, int y) {
        new TouchAction(driver)
                .press(point(xStart, y))
                .waitAction(waitOptions(ofSeconds(waitOptionsDuration)))
                .moveTo(point(xEnd, y))
                .release().perform();
    }

    //Vertical Swipe by percentages
    public static void verticalSwipeByPercentages(AndroidDriver driver, double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        new TouchAction(driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofSeconds(waitOptionsDuration)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
    }

    public static void verticalSwipeByCoordinates(AndroidDriver driver, int x, int yStart, int yEnd) {
        new TouchAction(driver)
                .press(point(x, yStart))
                .waitAction(waitOptions(ofSeconds(waitOptionsDuration)))
                .moveTo(point(x, yEnd))
                .release().perform();
    }

    public static TouchAction touchAction(AndroidDriver driver) {
        return new TouchAction(driver);
    }

}
