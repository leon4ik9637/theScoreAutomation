package mobile.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){

    }

    private static AndroidDriver androidDriver;

    public static AndroidDriver getAndroidDriver() throws MalformedURLException {
        if (androidDriver == null) {
            File appFile = new File(ConfigReader.getProperty("apkAppPath"));    //Stores the app path
            DesiredCapabilities caps = new DesiredCapabilities();   //Setting up the mobile device with below values

            caps.setCapability("platformName", ConfigReader.getProperty("platformName"));
            caps.setCapability("appium:automationName", ConfigReader.getProperty("automationName"));
            caps.setCapability("appium:deviceName", ConfigReader.getProperty("deviceName"));
            caps.setCapability("app", appFile.getAbsolutePath()); //absolute path not content root

            URL appiumServerUrl = new URL("http://127.0.0.1:4723"); //server url comes in here
            androidDriver = new AndroidDriver(appiumServerUrl, caps);
            androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
        return androidDriver;

    }


    public static void quitDriver(){
        if (androidDriver != null) {
            androidDriver.quit();
            androidDriver = null;
        }
    }
}
