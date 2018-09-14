package testBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class TestBase {

    protected static AndroidDriver<AndroidElement> mdriver;
    protected static WebDriver wdriver;

    private static DesiredCapabilities getDesiredCapabilities() {

        //Appium settings for chris arroyo app
        String deviceName="NA";
        String androidVersion="8.0.0";
        String appPackage="info.chrisarroyo.chrisarroyoapp";
        String appActivity=".MainActivity";
        String commandTimeout="120";

        //Setup Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", androidVersion);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("newCommandTimeout", commandTimeout);

        return capabilities;
    }

    public static void mobileSetup() throws IOException{

        String appiumDriverURL="http://127.0.0.1:4723/wd/hub";

        //Setup Appium
        DesiredCapabilities capabilities = getDesiredCapabilities();

        //Check if mobile driver has already been instantiated
        if(mdriver == null){
            mdriver = new AndroidDriver<>(new URL(appiumDriverURL), capabilities);

            try {
                //Give the app time to load
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // method to start webdriver
    protected void webSetup() throws IOException{

        //Check if web driver has already been instantiated
        //Driver options are 'PhantomJSDriver', 'ChromeDriver', 'FireFoxDriver'
        if(wdriver == null){
            wdriver = new ChromeDriver();
        }
        loadResumeSite();
    }

    // method to use after test classes
    protected static void webClose(){
        wdriver.quit();
        wdriver = null;
    }

    //Method that loads chrisarroyo.info
    private void loadResumeSite(){
        String chrisarroyoUrl = "http://chrisarroyo.info";
        wdriver.get(chrisarroyoUrl);
        wdriver.manage().window().maximize();
    }

    protected void failedTestCaseSteps(String e){
        //testRailFailResult(caseNum);
        Assert.fail(String.valueOf(e));
    }

}
