package mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TheScoreLogInPage {
    public TheScoreLogInPage(AndroidDriver androidDriver){
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(xpath = "//emailInputBoxLocator")
    public WebElement emailInputBox;

    @AndroidFindBy(xpath = "//passwordInputBoxLocator")
    public WebElement passwordInputBox;

    @AndroidFindBy(xpath = "//loginButtonLocator")
    public WebElement loginButton;

    @AndroidFindBy(xpath = "//gotItPopup")
    public WebElement gotItPopup;

}
