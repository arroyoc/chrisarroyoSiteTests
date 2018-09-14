package pageObjects.ChrisArroyoApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class HomeScreen extends MobilePageObjectsBase{

    private By acountLoginBtn = By.id("Account Login");

    public HomeScreen(AppiumDriver<AndroidElement> driver){
        super(driver);
    }

    public AccountLoginScreen clickAccountLogin(){
        waitAndClick(acountLoginBtn);
        return new AccountLoginScreen(driver);
    }
}
