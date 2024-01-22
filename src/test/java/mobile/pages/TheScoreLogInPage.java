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

    @AndroidFindBy(id = "com.fivemobile.thescore:id/email_input_edittext")
    public WebElement emailInputBox;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/password_input_edittext")
    public WebElement passwordInputBox;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/action_button_text")
    public WebElement loginPageLoginButton;

    @AndroidFindBy(xpath = "//gotItPopup")
    public WebElement gotItPopup;

}
