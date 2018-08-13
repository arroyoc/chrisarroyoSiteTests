package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaygroundFormsPage extends PageObjectsBase{

    private By emailForm1 = By.id("form1Email");
    private By passForm1 = By.id("form1Password");
    private By submitForm1 = By.xpath("/html/body/div/form[1]/div[4]/button");

    public PlaygroundFormsPage(WebDriver driver){
        super(driver);
    }

    public PlaygroundFormsPage typeEmailForm1(String email){
        waitForElement(emailForm1).sendKeys(email);
        return this;
    }

    public PlaygroundFormsPage typePassForm1(String pass){
        waitForElement(passForm1).sendKeys(pass);
        return this;
    }

    public PlaygroundFormsPage clickSubmitForm1(){
        waitAndClick(submitForm1);
        return this;
    }
}
