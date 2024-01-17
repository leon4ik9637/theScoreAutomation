package mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TheScoreHomePage {
    public TheScoreHomePage(AndroidDriver androidDriver){
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(id = "Assuming Leagues button is a Web Element, not in the List of web elements")
    public WebElement leaguesButton;
}
