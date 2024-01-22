package mobile.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;


public class AppiumScroll {

    public static void verticalScroll(AndroidDriver driver){
        WebElement ele01 = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/recyclerView"));

        int centerX = ele01.getRect().x + (ele01.getSize().width/2);

        double startY = ele01.getRect().y + (ele01.getSize().height * 0.9);

        double endY = ele01.getRect().y + (ele01.getSize().height * 0.2);

        //Type of Pointer Input
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        //Creating Sequence object to add actions
        Sequence swipe = new Sequence(finger, 1);
        //Move finger into starting position
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(),
                centerX, (int)startY));
        //Finger comes down into contact with screen
        swipe.addAction(finger.createPointerDown(0));
        //Finger moves to end position
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(),
                centerX, (int)endY));
        //Get up Finger from Screen
        swipe.addAction(finger.createPointerUp(0));

        //Perform the actions
        driver.perform(Arrays.asList(swipe));
    }

}

