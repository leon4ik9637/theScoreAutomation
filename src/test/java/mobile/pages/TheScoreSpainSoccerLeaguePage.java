package mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TheScoreSpainSoccerLeaguePage {
    public TheScoreSpainSoccerLeaguePage(AndroidDriver androidDriver){
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(xpath = "subtabslocator")
    public List<WebElement> spainSoccerLeagueTabs;

    @AndroidFindBy(id = "backNavigationButton")                  // Assuming the one on the left top corner
    public WebElement spainSoccerLeagueBackNavigationButton;     // If I were sure that every league's back navigation
                                                                 // button has the same locator then I would locate it differently.
                                                                 // Thus, will be here.

    public void selectTabFromSpainLeagueTabs (String spainSoccerLeagueTab){
        for(WebElement element : spainSoccerLeagueTabs){
            if(element.getText().equalsIgnoreCase(spainSoccerLeagueTab)){
                element.click();
                break;
            }
        }
    }

    public void isTabFromSpainLeagueTabsSelected(String spainSoccerLeagueTab){
        for(WebElement element : spainSoccerLeagueTabs){
            if(element.getText().equalsIgnoreCase(spainSoccerLeagueTab)){
                Assert.assertTrue(element.isSelected());
            }
        }
    }

}
