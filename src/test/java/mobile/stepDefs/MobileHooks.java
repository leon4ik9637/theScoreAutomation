package mobile.stepDefs;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import mobile.pages.*;
import mobile.utils.ConfigReader;
import mobile.utils.Driver;


public class MobileHooks {
    public static AndroidDriver androidDriver;
    public static TheScoreHomePage theScoreHomePage;
    public static TheScoreWelcomePage theScoreWelcomePage;
    public static TheScoreLogInPage theScoreLogInPage;
    public static TheScoreLeaguesPage theScoreLeaguesPage;
    public static TheScoreSpainSoccerLeaguePage theScoreSpainSoccerLeaguePage;

    @Before
    public void setup() throws Exception {
        switch (ConfigReader.getProperty("testing")) {

//            case "browser":                                       // IN CASE WE NEED TO SWITCH BETWEEN BROWSER WEBDRIVER AND MOBILE
//                webDriver = Driver.getWebDriver();
//                ebayHomePage = new EbayHomePage(webDriver);
//                amazonHomePage = new AmazonHomePage(webDriver);
//                break;
//
            case "app":
                androidDriver = Driver.getAndroidDriver();
                theScoreHomePage = new TheScoreHomePage(androidDriver);
                theScoreWelcomePage = new TheScoreWelcomePage(androidDriver);
                theScoreLogInPage = new TheScoreLogInPage(androidDriver);
                theScoreLeaguesPage = new TheScoreLeaguesPage(androidDriver);
                theScoreSpainSoccerLeaguePage = new TheScoreSpainSoccerLeaguePage(androidDriver);
                break;
            default:
                throw new Exception("Testing value not found from configuration.properties!");
        }
    }

    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
