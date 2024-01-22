package mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TheScoreSpainSoccerLeaguePage {
    public TheScoreSpainSoccerLeaguePage(AndroidDriver androidDriver){
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(id = "com.fivemobile.thescore:id/titleTextView")
    public WebElement SpainSoccerTitleText;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Table\"]")
    public WebElement spainSoccerLeagueTabs;

    @AndroidFindBy(accessibility = "Navigate up")
    public WebElement spainSoccerLeagueBackNavigationButton;


}
