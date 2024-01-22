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

    @AndroidFindBy(id = "com.fivemobile.thescore:id/dismiss_modal")
    public WebElement popupAdDismissal;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/btn_allow")
    public WebElement allowLocationButton;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public WebElement permissionAllowButton;

    @AndroidFindBy(accessibility = "Leagues")
    public WebElement leaguesButton;


}
