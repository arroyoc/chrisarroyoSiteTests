package testBase;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    protected static WebDriver wdriver;

    private String chrisarroyoUrl;


    private void loadConfig() throws IOException{

        //Config property file
        Properties CONFIG = new Properties();
        FileInputStream fn = new FileInputStream(System.getProperty("user.dir")+"//src//config/config.properties");
        CONFIG.load(fn);

        chrisarroyoUrl = CONFIG.getProperty("chrisarroyoUrl");

    }

    // method to start webdriver
    protected void webSetup() throws IOException{

        loadConfig();

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
        wdriver.get(chrisarroyoUrl);
        wdriver.manage().window().maximize();
    }

    public void failedTestCaseSteps(String e){
        //testRailFailResult(caseNum);
        Assert.fail(String.valueOf(e));
    }

}
