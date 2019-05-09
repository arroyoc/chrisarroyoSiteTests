package testBase;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

public class TestBase {

    protected static WebDriver wdriver;

    // method to start webdriver
    protected static void webSetup() throws IOException{

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
    private static void loadResumeSite(){
        String chrisarroyoUrl = "http://chrisarroyo.info";
        wdriver.get(chrisarroyoUrl);
        wdriver.manage().window().maximize();
    }

    protected void failedTestCaseSteps(String e){
        //testRailFailResult(caseNum);
        Assert.fail(String.valueOf(e));
    }

}
