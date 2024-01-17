package mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TheScoreLeaguesPage {
    public TheScoreLeaguesPage(AndroidDriver androidDriver){
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }


    @AndroidFindBy(id = "locator for the list of leagues")
    public List<WebElement> leagueOptions;

    public void selectLeagueFromListOfLeagues(String leagueOption){
        for(WebElement element : leagueOptions){
            if(element.getText().equalsIgnoreCase(leagueOption)){
                element.click();
                break;
            }
        }
    }

}
