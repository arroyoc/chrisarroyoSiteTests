package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    protected static Properties CONFIG=null;
    protected static WebDriver wdriver;

    protected String chrisarroyoUrl;


    public void loadConfig() throws IOException{

        //Config property file
        CONFIG= new Properties();
        FileInputStream fn = new FileInputStream(System.getProperty("user.dir")+"//src//config/config.properties");
        CONFIG.load(fn);

        chrisarroyoUrl = CONFIG.getProperty("chrisarroyoUrl");

    }

    public void webSetup() throws IOException {

        loadConfig();

        //Check if web driver has already been instantiated
        //Driver options are 'PhantomJSDriver', 'ChromeDriver', 'FireFoxDriver'
        if(wdriver == null){
            wdriver = new FirefoxDriver();
        }
    }
}
