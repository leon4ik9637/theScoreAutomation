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

    @AndroidFindBy(id = "com.fivemobile.thescore:id/league_name_text")
    public List<WebElement> leagueOptions;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/titleTextView")
    public WebElement leaguesTitleText;

    public void selectLeagueFromListOfLeagues(String leagueOption){
        for(WebElement element : leagueOptions){
            String textAttribute = element.getAttribute("text");

            if(leagueOption.equals(textAttribute)){
                element.click();
                break;
            }
        }
    }

}
