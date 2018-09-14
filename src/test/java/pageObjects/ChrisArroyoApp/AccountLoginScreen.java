package pageObjects.ChrisArroyoApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class AccountLoginScreen extends MobilePageObjectsBase {

    private By emailField = By.id("Email");
    private By passField = By.id("Password (optional)");
    private By submitBtn = By.id("Sign in or register");

    public AccountLoginScreen(AppiumDriver<AndroidElement> driver){
        super(driver);
    }

    public AccountLoginScreen typeEmail(String email){
        waitForElement(emailField).sendKeys(email);
        return this;
    }

    public AccountLoginScreen typePass(String pass){
        waitForElement(passField).sendKeys(pass);
        return this;
    }

    public HomeScreen clickSubmit(){
        waitAndClick(submitBtn);
        return new HomeScreen(driver);
    }
}
